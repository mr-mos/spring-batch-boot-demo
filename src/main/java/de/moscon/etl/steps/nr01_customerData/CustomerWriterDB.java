package de.moscon.etl.steps.nr01_customerData;

import de.moscon.etl.beans.Customer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;


@Component
public class CustomerWriterDB extends JdbcBatchItemWriter<Customer> {

    public CustomerWriterDB(@Qualifier ("mySql") DataSource dataSource) {
        setDataSource(dataSource);
        setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        setSql("INSERT INTO kunden_org (customerId, pseudonym, gender, birthdayFormatted, zipCode, city, registrationDateFormatted) VALUES (:id, :pseudonym, :genderFormatted, :birthday, :zipCode, :city, :registrationDate);");
    }



}
