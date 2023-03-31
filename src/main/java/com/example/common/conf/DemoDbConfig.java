package com.example.common.conf;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.example.common.repository.demo", entityManagerFactoryRef = "demoEntityManager", transactionManagerRef = "demoTransactionManager")
public class DemoDbConfig {

	@Bean(name = "demoEntityManager")
	@Primary
	public EntityManagerFactory demoEntityManager(@Qualifier("demoDatasource") DataSource demoDatasource) {

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(demoDatasource);
        factory.setPackagesToScan("com.example.common.entity.demo", "com.example.common.dto.demo");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.afterPropertiesSet();

        return factory.getObject();
        
        
	}

	@Bean(name = "demoDbProperties")
	@ConfigurationProperties(prefix = "spring.datasource.demo")
	public DataSourceProperties demoDatasourceProperties() {
		return new DataSourceProperties();
	}

	@Bean(name = "demoDatasource")
	@Primary
	public DataSource demoDatasource(@Qualifier("demoDbProperties") DataSourceProperties demoDatasourceProperties) {
		return demoDatasourceProperties.initializeDataSourceBuilder().build();
	}

	@Bean(name = "demoTransactionManager")
	protected PlatformTransactionManager demoTransactionManager(@Qualifier("demoDatasource") DataSource demoDatasource) {
		return new DataSourceTransactionManager(demoDatasource);
	}

}
