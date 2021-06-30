package de.moscon.etl.steps.nr01_customerData;

import de.moscon.etl.beans.Customer;
import de.moscon.etl.beans.enums.Gender;
import de.moscon.extern_systems.CustomerSimulator;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.stereotype.Component;

@Component
public class CustomerReader extends FlatFileItemReader<Customer> {

	private CustomerSimulator customerSimulator;


	public CustomerReader(CustomerSimulator customerSimulator) {
		this.customerSimulator = customerSimulator;
		setResource(customerSimulator.importDataAsCsv());
		setLineMapper(createLineMapper());
		setLinesToSkip(1);   // don't read header line
	}


	private LineMapper<Customer> createLineMapper() {
		DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer(";");
		tokenizer.setStrict(true);
		DefaultLineMapper<Customer> lineMapper = new DefaultLineMapper<Customer>();
		lineMapper.setLineTokenizer(tokenizer);
		lineMapper.setFieldSetMapper(fieldSet -> {
			Customer customer = new Customer();
			customer.setId(fieldSet.readLong(0));
			customer.setFirstname(fieldSet.readString(1));
			customer.setBirthday(fieldSet.readDate(3,"dd.MM.yyyy"));
			customer.setZipCode(fieldSet.readString(4));
			customer.setCity(fieldSet.readString(5));
			customer.setRegistrationDate(fieldSet.readDate(8,"dd.MM.yyyy"));
			customer.setGender(fieldSet.readString(9).equals("m")? Gender.MALE: (fieldSet.readString(9).equals("w")? Gender.FEMALE: Gender.DIVERS));
			return customer;
		});
		return lineMapper;
	}


}
