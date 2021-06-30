package de.moscon.etl.steps.nr03_salesData;

import de.moscon.etl.beans.Sale;
import de.moscon.etl.setter.SaleItemPreparedStmSetter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class SalesWriter extends JdbcBatchItemWriter<Sale> {

	public SalesWriter(@Qualifier("dataSourceMySql") DataSource dataSourceMySql){
		setDataSource(dataSourceMySql);
		setSql("INSERT INTO sale (product_id, customer_id, count, net_price_sum_formatted, time_formatted) VALUES (?, ?, ?, ?, ?)");
		setItemPreparedStatementSetter(new SaleItemPreparedStmSetter());
	}

}
