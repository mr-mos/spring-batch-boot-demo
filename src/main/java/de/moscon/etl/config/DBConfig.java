package de.moscon.etl.config;

import de.moscon.etl.beans.Customer;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

@Configuration
public class DBConfig {

//    @Value("org/springframework/batch/core/schema-drop-mysql.sql")
//    private Resource dropReopsitoryTables;
//
//    @Value("org/springframework/batch/core/schema-mysql.sql")
//    private Resource dataReopsitorySchema;


//    private static NamedParameterJdbcTemplate jdbcTemplate;
//
//	@Bean
//	NamedParameterJdbcTemplate jdbcTemplate(DataSource dataSource) {
//		return new NamedParameterJdbcTemplate(dataSource);
//	}

    @Bean
    public DataSource dataSource2() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/lab806");
        dataSource.setUsername("root");
        dataSource.setPassword("#t2rfortheMax");
        return dataSource;
    }

//    @Bean
//	ItemWriter<Customer> csvFileDatabaseItemWriter(DataSource dataSource, NamedParameterJdbcTemplate jdbcTemplate) {
//        JdbcBatchItemWriter<Customer> databaseItemWriter = new JdbcBatchItemWriter<>();
//        databaseItemWriter.setDataSource(dataSource);
//        databaseItemWriter.setJdbcTemplate(jdbcTemplate);
//        return databaseItemWriter;
//    }



//    @Bean
//    public DataSourceInitializer dataSourceInitializer2(DataSource dataSource) {
//        ResourceDatabasePopulator databasePopulator =
//                new ResourceDatabasePopulator();
//
//        databasePopulator.addScript(dropReopsitoryTables);
//        databasePopulator.addScript(dataReopsitorySchema);
//        databasePopulator.setIgnoreFailedDrops(true);
//
//
//        DataSourceInitializer initializer = new DataSourceInitializer();
//        initializer.setDataSource(dataSource);
//        initializer.setDatabasePopulator(databasePopulator);
//
//        return initializer;
//    }

}




