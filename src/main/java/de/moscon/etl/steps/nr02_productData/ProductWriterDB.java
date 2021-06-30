package de.moscon.etl.steps.nr02_productData;

import de.moscon.etl.beans.Customer;
import de.moscon.etl.beans.Product;
import de.moscon.etl.steps.StepUtils;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class ProductWriterDB extends JdbcBatchItemWriter<Product> {

	private Resource outputResource = new FileSystemResource("data/output/produkte_tennisshop.csv");

	public ProductWriterDB(@Qualifier("mySql") DataSource dataSource) {
		setDataSource(dataSource);
		setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
		setSql("INSERT INTO tennisshop.produkte_tennisshop" +
				"(id,	displayName, netPriceFormatted,	category, playerBrand)" +
				"VALUES (:id, :displayName,	:netPrice, :category, :playerBrand);");
	}

}
