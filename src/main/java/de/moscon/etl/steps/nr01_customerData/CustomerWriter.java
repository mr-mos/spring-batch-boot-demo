package de.moscon.etl.steps.nr01_customerData;

import de.moscon.etl.beans.Customer;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class CustomerWriter extends FlatFileItemWriter<Customer> {

	private Resource outputResource = new FileSystemResource("data/output/kunden_tennisshop.csv");

	public CustomerWriter() {
		setResource(outputResource);
		// setAppendAllowed(true);
		setLineAggregator(createLineAggregator());
		setHeaderCallback(writer -> {
			writer.write(String.join(";",getFields()));
		});
	}



	private DelimitedLineAggregator<Customer> createLineAggregator() {
		BeanWrapperFieldExtractor<Customer> beanFieldMapper = new BeanWrapperFieldExtractor<>();
		beanFieldMapper.setNames(getFields());
		DelimitedLineAggregator<Customer> lineAggregator = new DelimitedLineAggregator<>();
		lineAggregator.setDelimiter(";");
		lineAggregator.setFieldExtractor(beanFieldMapper);
		return lineAggregator;
	}


	private String[] getFields() {
		return new String[]{"id", "pseudonym", "gender", "birthday", "zipCode", "city", "registrationDate"};
	}
}
