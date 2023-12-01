package com.synergisticit.config;

import java.util.Properties;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.synergisticit.domain.Airlines;
import com.synergisticit.domain.Airport;
import com.synergisticit.domain.Flight;
import com.synergisticit.domain.Passenger;
import com.synergisticit.domain.Reservation;
import com.synergisticit.domain.Role;
import com.synergisticit.domain.User;

import jakarta.persistence.spi.PersistenceProvider;

@Configuration
@PropertySource(value="classpath:db.properties")
public class AppConfig {
	@Autowired
	Environment env;
	
	@Bean
	public DriverManagerDataSource dataSource() {
		
//		System.out.println("url: "+env.getProperty("url"));
//		System.out.println("driver: "+env.getProperty("driver"));
//		System.out.println("user name: "+env.getProperty("myusername"));
//		System.out.println("password: "+env.getProperty("mypassword"));
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(env.getProperty("url"));
		dataSource.setDriverClassName(env.getProperty("driver"));
		dataSource.setUsername(env.getProperty("myusername"));
		dataSource.setPassword(env.getProperty("mypassword"));
		
		return dataSource;
	}
	
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource());
		
		return jdbcTemplate;
	}
	
	
	@Primary
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean =  new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setPackagesToScan("com.synergisticit.domain");
		entityManagerFactoryBean.setPersistenceProvider(new HibernatePersistenceProvider());
		entityManagerFactoryBean.setJpaProperties(hibernateProerties());
		
		return entityManagerFactoryBean;
		
	}
	
	
	
	
		public LocalSessionFactoryBean sessionFactory() {
			System.out.println("LocalSessionFactoryBean sessionFactory from AppConfig...");
			LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
			sessionFactory.setDataSource(dataSource());
			sessionFactory.setAnnotatedClasses(User.class,Airlines.class,Airport.class,Flight.class,Passenger.class,Reservation.class,Role.class);
			sessionFactory.setPackagesToScan("com.synergisticit.domain");
			sessionFactory.setHibernateProperties(hibernateProerties());
			
			return sessionFactory;
		}

		
		Properties hibernateProerties() {
			Properties jpaProerties = new Properties();
			jpaProerties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
			jpaProerties.setProperty("hibernate.show_SQL", "true");
			//jpaProerties.setProperty("hibernate.hbm2ddl.auto", "create");
			jpaProerties.setProperty("hibernate.hbm2ddl.auto", "update");
			return jpaProerties;
		}
		
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		return viewResolver;
	}
	
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasenames("WEB-INF/message/messages");
		return messageSource;
	}
}
