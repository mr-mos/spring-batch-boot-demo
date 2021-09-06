package de.moscon.etl.steps.nr01_customerData;

import de.moscon.etl.beans.Customer;
import de.moscon.etl.steps.StepUtils;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class CustomerWriter extends FlatFileItemWriter<Customer> {

	private Resource outputResource = new FileSystemResource("data/output/kunden_tennisshop.csv");

	public CustomerWriter() {
		setResource(outputResource);
		// setAppendAllowed(true);
		setLineAggregator(StepUtils.createLineAggregator(getFields()));
		setHeaderCallback(writer -> {
			writer.write(String.join(";",getFields()));
		});
	}


	private String[] getFields() {
		return new String[]{"id", "pseudonym", "gender", "birthdayFormatted", "zipCode", "city", "registrationDateFormatted"};
	}
}
