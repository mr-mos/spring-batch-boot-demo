package de.moscon.etl.config;

import de.moscon.etl.beans.Customer;
import de.moscon.etl.listener.JobCompletionListener;
import de.moscon.etl.steps.nr01_customerData.CustomerProcessor;
import de.moscon.etl.steps.nr01_customerData.CustomerReader;
import de.moscon.etl.steps.nr01_customerData.CustomerWriter;
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



	@Bean
	public Job tennisShopJob() {
		return jobBuilderFactory
				.get("tennisShopJob")
				.incrementer(new RunIdIncrementer()).listener(new JobCompletionListener())
				.flow(customerDataStep())
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
