package de.moscon.etl.steps.nr01_customerData;

import de.moscon.etl.beans.Customer;

import de.moscon.etl.setter.CustomerItemPreparedStmSetter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class CustomerWriter extends JdbcBatchItemWriter<Customer> {

	public CustomerWriter(@Qualifier("dataSourceMySql") DataSource dataSourceMySql){
		setDataSource(dataSourceMySql);
		setSql("INSERT INTO customer (pseudonym, gender, birthday_formatted, zip_code, city, registration_date_formatted) VALUES (?, ?, ?, ?, ?, ?)");
		setItemPreparedStatementSetter(new CustomerItemPreparedStmSetter());
	}


}
