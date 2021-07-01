package de.moscon.etl.steps.nr03_salesData;

import de.moscon.etl.beans.Sale;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class SalesWriterDB extends JdbcBatchItemWriter<Sale> {

    public SalesWriterDB(@Qualifier("mySql") DataSource dataSource) {
        setDataSource(dataSource);
        setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        setSql("INSERT INTO sales_tennisshop" +
                "(id,	productId, customerId,	count, netPriceFormatted, time)" +
                "VALUES (:id, :productId, :customerId, :count, :netPriceSum, :time) " +
                "ON DUPLICATE KEY UPDATE " +
                "productId=values(productId)," +
                "customerId=values(customerId)," +
                "count=values(count),"+
                "netPriceFormatted=values(netPriceFormatted)," +
                "time=values(time);");

//        "INSERT INTO sales_tennisshop (id, productId, customerId, count, netPriceFormatted, time) VALUES (:id, :productId, :customerId, :count, :netPriceSum, :time);");

    }

}
