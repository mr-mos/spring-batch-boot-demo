package de.moscon.etl.steps.nr01_customerData;

import de.moscon.etl.beans.Customer;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class CustomerWriter extends JdbcBatchItemWriter<Customer> {

	private Resource outputResource = new FileSystemResource("data/output/kunden_tennisshop.csv");


	public CustomerWriter(@Qualifier("dataSourceMySql") DataSource dataSourceMySql) {
		setDataSource(dataSourceMySql);
		setSql("INSERT INTO.....");
	}


}
