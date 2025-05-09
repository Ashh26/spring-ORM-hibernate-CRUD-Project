package com.springCore_JDBC_ORM.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.springCore_JDBC_ORM.dao.Impl.UserDaoImpl;
import com.springCore_JDBC_ORM.entities.User;

@Configuration
@EnableTransactionManagement
public class JavaConfig {

	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/springorm");
		dataSource.setUsername("root");
		dataSource.setPassword("admin");
		return dataSource;
	}
	@Bean
	public Properties properties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		properties.put("hibernate.show_sql","true");
		properties.put("hibernate.hbm2ddl.auto","update");
		return properties;
	}
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setDataSource(dataSource());
		factoryBean.setHibernateProperties(properties());
		factoryBean.setAnnotatedClasses(User.class);
		return factoryBean;
	}
	@Bean
	public HibernateTemplate hibernateTemplate() {
		HibernateTemplate template = new HibernateTemplate();
		template.setSessionFactory(sessionFactory().getObject());
		return template;
	}
	@Bean
	public UserDaoImpl daoImpl() {
		UserDaoImpl daoImpl = new UserDaoImpl();
		daoImpl.setHibernateTemplate(hibernateTemplate());
		return daoImpl;
	}
	@Bean
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}
}
