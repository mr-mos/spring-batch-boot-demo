package de.moscon.etl.steps.nr03_salesData;

import de.moscon.etl.beans.Product;
import de.moscon.etl.beans.Sale;
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
public class SalesWriter extends JdbcBatchItemWriter<Sale> {

		public SalesWriter(@Qualifier("dataSourceMySql") DataSource dataSourceMySql) {
			setDataSource(dataSourceMySql);
			setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
			setSql("INSERT INTO sale (id, count, net_price_sum, time_, customer_id, product_id) VALUES (:id, :count, :netPriceSum, :time, :customerId, :productId)");
		}

//	private Resource outputResource = new FileSystemResource("data/output/sales_tennisshop.csv");
//
//	public SalesWriter() {
//		setResource(outputResource);
//		setLineAggregator(StepUtils.createLineAggregator(getFields()));
//		setHeaderCallback(writer -> {
//			writer.write(String.join(";", getFields()));
//		});
//	}
//
//
//
//	private String[] getFields() {
//		return new String[]{"id", "productId", "customerId", "count", "netPriceSumFormatted", "timeFormatted"};
//	}

}
