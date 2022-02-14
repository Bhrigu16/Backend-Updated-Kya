package com.backend.dbManagers;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.google.common.base.Preconditions;

@Configuration
@PropertySource({ "classpath:database.properties" })
@EnableJpaRepositories(basePackages = "com.backend.repository.postgis", entityManagerFactoryRef = "postgisEntityManager", transactionManagerRef = "postgisTransactionManager")
public class PersistencePostGisConfiguration {

	@Autowired
	private Environment env;

	public PersistencePostGisConfiguration() {
		super();
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean postgisEntityManager() {
		final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(postgisDataSource());
		em.setPackagesToScan("com.backend.model");

		final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		final HashMap<String, Object> properties = new HashMap<String, Object>();
		properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.ddl-auto"));
		properties.put("hibernate.dialect", env.getProperty("postgis.hibernate.dialect"));
		em.setJpaPropertyMap(properties);

		return em;
	}

	@Bean
	public DataSource postgisDataSource() {
		final DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(Preconditions.checkNotNull(env.getProperty("jdbc.driverClassName")));
		dataSource.setUrl(Preconditions.checkNotNull(env.getProperty("jdbc.url")));
		dataSource.setUsername(Preconditions.checkNotNull(env.getProperty("jdbc.user")));
		dataSource.setPassword(Preconditions.checkNotNull(env.getProperty("jdbc.pass")));

		return dataSource;
	}

	@Bean
	public PlatformTransactionManager postgisTransactionManager() {
		final JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(postgisEntityManager().getObject());
		return transactionManager;
	}
}
