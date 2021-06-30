package de.moscon.etl.config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

	@Value("org/springframework/batch/core/schema-drop-sqlite.sql")
	private Resource dropReopsitoryTables;
	@Value("org/springframework/batch/core/schema-sqlite.sql")
	private Resource dataReopsitorySchema;

	@Primary
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.sqlite.JDBC");
		dataSource.setUrl("jdbc:sqlite:repository.sqlite");
		return dataSource;
	}

	@Bean
	public DataSource dataSourceMySql() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/tennisshop");
		dataSource.setUsername("root");
		dataSource.setPassword("online00");
		return dataSource;
	}


	@Bean
	public DataSourceInitializer dataSourceInitializer(DataSource dataSource) {
		ResourceDatabasePopulator databasePopulator =
				new ResourceDatabasePopulator();
		databasePopulator.addScript(dropReopsitoryTables);
		databasePopulator.addScript(dataReopsitorySchema);
		databasePopulator.setIgnoreFailedDrops(true);
		DataSourceInitializer initializer = new DataSourceInitializer();
		initializer.setDataSource(dataSource);
		initializer.setDatabasePopulator(databasePopulator);
		return initializer;
	}


}