package de.moscon.etl.steps.nr02_productData;

import de.moscon.etl.beans.Product;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class ProductWriterDB extends JdbcBatchItemWriter<Product> {


    public ProductWriterDB(@Qualifier("mySql") DataSource dataSource) {
        setDataSource(dataSource);
        setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());


        setSql("INSERT INTO produkte_tennisshop" +
                "(productId, displayName, netPriceFormatted, category, playerBrand)" +
                "VALUES (:id, :displayName,	:netPrice, :category, :playerBrand) " +
                "ON DUPLICATE KEY UPDATE " +
                "displayName=values(displayName)," +
                "netPriceFormatted=values(netPriceFormatted)," +
                "category=values(category),"+
                "playerBrand=values(playerBrand);");

//        (productId, displayName, netPriceFormatted, playerBrand) VALUES (:id, :displayName, :netPrice, :playerBrand);");
    }

}
