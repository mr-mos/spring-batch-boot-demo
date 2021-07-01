package de.moscon.etl.steps.nr02_productData;

import de.moscon.etl.beans.Product;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class ProductWriter extends JdbcBatchItemWriter<Product> {

	public ProductWriter(@Qualifier("dataSourceMySql") DataSource dataSourceMySql) {
		setDataSource(dataSourceMySql);
		setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
		setSql("INSERT INTO product (id, display_name, net_price, category, player_brand) VALUES (:id, :displayName, :netPrice, :category, :playerBrand);");
	}


}
