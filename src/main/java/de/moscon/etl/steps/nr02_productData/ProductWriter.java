package de.moscon.etl.steps.nr02_productData;

import de.moscon.etl.beans.Customer;
import de.moscon.etl.beans.Product;
import de.moscon.etl.setter.CustomerItemPreparedStmSetter;
import de.moscon.etl.setter.ProductItemPreparedStmSetter;
import de.moscon.etl.steps.StepUtils;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class ProductWriter extends JdbcBatchItemWriter<Product> {

	public ProductWriter(@Qualifier("dataSourceMySql") DataSource dataSourceMySql){
		setDataSource(dataSourceMySql);
		setSql("INSERT INTO product (display_name, net_price_formatted, category, player_brand) VALUES (?, ?, ?, ?)");
		setItemPreparedStatementSetter(new ProductItemPreparedStmSetter());
	}


}
