/**
 * 
 */
package com.lichengbao.auth;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * @author jwang
 *
 */
@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "securityEntityManagerFactory")
public class SecurityDataConfig {
	
	@Autowired
	private Properties hibernateProperties;
	
//	@Bean
	PlatformTransactionManager customerTransactionManager() {
		return new JpaTransactionManager(securityEntityManagerFactory().getObject());
	}
	
	@Bean
	LocalContainerEntityManagerFactoryBean securityEntityManagerFactory() {
		
		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();

		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

		factoryBean.setDataSource(securityDataSource());
		factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
		factoryBean.setPackagesToScan("com.lichengbao.auth");
		Properties properties = (Properties) this.hibernateProperties.clone();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
//		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.ejb.entitymanager_factory_name", "securityEntityManagerFactory");
		factoryBean.setJpaProperties(properties);

		return factoryBean;

	}
	
	@Bean
	DataSource securityDataSource() {
		return
			new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.H2)
				.addScripts("classpath:META-INF/sql/schema.sql", "classpath:META-INF/sql/data.sql")
				.build();
	}

}
