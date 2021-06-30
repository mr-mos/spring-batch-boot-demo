package de.moscon.etl.config;

import de.moscon.etl.beans.Customer;
import de.moscon.etl.beans.Product;
import de.moscon.etl.beans.Sale;
import de.moscon.etl.listener.JobCompletionListener;
import de.moscon.etl.steps.nr01_customerData.CustomerProcessor;
import de.moscon.etl.steps.nr01_customerData.CustomerReader;
import de.moscon.etl.steps.nr01_customerData.CustomerWriter;
import de.moscon.etl.steps.nr02_productData.ProductProcessor;
import de.moscon.etl.steps.nr02_productData.ProductReader;
import de.moscon.etl.steps.nr02_productData.ProductWriter;
import de.moscon.etl.steps.nr03_salesData.SalesReader;
import de.moscon.etl.steps.nr03_salesData.SalesWriter;
import de.moscon.etl.steps.testText.SimpleProcessor;
import de.moscon.etl.steps.testText.SimpleReader;
import de.moscon.etl.steps.testText.SimpleWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BatchDemoConfig {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;


	@Autowired
	private CustomerProcessor customerProcessor;
	@Autowired
	private CustomerReader customerReader;
	@Autowired
	private CustomerWriter customerWriter;

	@Autowired
	private ProductProcessor productProcessor;
	@Autowired
	private ProductReader productReader;
	@Autowired
	private ProductWriter productWriter;

	@Autowired
	private SalesReader salesReader;
	@Autowired
	private SalesWriter salesWriter;


	@Bean
	public Job tennisShopJob() {
		return jobBuilderFactory
				.get("tennisShopJob")
				.incrementer(new RunIdIncrementer()).listener(new JobCompletionListener())
				.flow(customerDataStep())
				.next(productDataStep())
				.next(shopDataStep())
				.end()
				.build();
	}


	private Step customerDataStep() {
		return stepBuilderFactory
				.get("customerDataStep")
				.<Customer, Customer>chunk(10)
				.reader(customerReader)
				.processor(customerProcessor)
				.writer(customerWriter)
				.build();
	}

	private Step productDataStep() {
		return stepBuilderFactory
				.get("productDataStep")
				.<Product, Product>chunk(5)
				.reader(productReader)
				.processor(productProcessor)
				.writer(productWriter)
				.build();
	}

	private Step shopDataStep() {
		return stepBuilderFactory
				.get("shopDataStep")
				.<Sale, Sale>chunk(20)
				.reader(salesReader)
				.writer(salesWriter)
				.build();
	}

	////////////////////////////////////


	@Bean
	public Job testJob() {
		return jobBuilderFactory
				.get("mosDemoJob")
				.incrementer(new RunIdIncrementer()).listener(new JobCompletionListener())
				.flow(testStep())
				.end()
				.build();
	}

	private Step testStep() {
		return stepBuilderFactory
				.get("testStep1")
				.<String, String>chunk(1)
				.reader(new SimpleReader()).processor(new SimpleProcessor())
				.writer(new SimpleWriter())
				.build();
	}


}
