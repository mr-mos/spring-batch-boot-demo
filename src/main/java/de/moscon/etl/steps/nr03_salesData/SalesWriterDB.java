package de.moscon.etl.steps.nr03_salesData;

import de.moscon.etl.beans.Product;
import de.moscon.etl.beans.Sale;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class SalesWriterDB extends JdbcBatchItemWriter<Sale> {

	private Resource outputResource = new FileSystemResource("data/output/produkte_tennisshop.csv");

	public SalesWriterDB(@Qualifier("mySql") DataSource dataSource) {
		setDataSource(dataSource);
		setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
		setSql("INSERT INTO tennisshop.sales_tennisshop" +
				"(id,	productId, customerId,	count, netPriceSumFormatted, timeFormatted)" +
				"VALUES (:id, :productId, :customerId, :count, :netPriceSum, :time);");
	}

}
