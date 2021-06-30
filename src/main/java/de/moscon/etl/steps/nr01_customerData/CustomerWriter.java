package de.moscon.etl.steps.nr01_customerData;

import de.moscon.etl.beans.Customer;

import de.moscon.etl.steps.StepUtils;
import org.springframework.batch.item.database.JdbcBatchItemWriter;

import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.stereotype.Component;
import org.springframework.core.io.Resource;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Component
public class CustomerWriter extends JdbcBatchItemWriter<Customer> {

//	private Resource outputResource = new FileSystemResource("data/output/kunden_tennisshop.csv");
//
// public CustomerWriter() {
//    setResource(outputResource);
//    // setAppendAllowed(true);
//    setLineAggregator(StepUtils.createLineAggregator(getFields()));
//    setHeaderCallback(writer -> {
//       writer.write(String.join(";",getFields()));
//    });
// }
//
//
// private String[] getFields() {
//    return new String[]{"id", "pseudonym", "gender", "birthdayFormatted", "zipCode", "city", "registrationDateFormatted"};
// }
//


	@Override
	public void write(List<? extends Customer> items) throws Exception {
		namedParameterJdbcTemplate.getJdbcOperations().batchUpdate("lab806", new BatchPreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				// set values on your sql
			}

			@Override
			public int getBatchSize() {
				return items.size(); // or any other value you want
			}
		});
	}


}
