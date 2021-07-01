package de.moscon.etl.steps.nr01_customerData;

import de.moscon.etl.beans.Customer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class CustomerWriter extends JdbcBatchItemWriter<Customer> {

	public CustomerWriter(@Qualifier("dataSourceMySql") DataSource dataSourceMySql) {
		setDataSource(dataSourceMySql);
		setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
		setSql("INSERT INTO customer (id, first_name, psydonym, birthday, zip_code, city, registration_date) VALUES (:id, :firstname, :pseudonym, :birthday, :zipCode, :city, :registrationDate)");
	}
}
