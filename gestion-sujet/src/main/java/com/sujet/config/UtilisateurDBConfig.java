package com.sujet.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
/*
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "utilisateurEntityManagerFactory",
        basePackages = {"com.utilisateur.repository"}
)*/
//@Profile("utilisateur")
public class UtilisateurDBConfig {
/*
	@Primary
	  @Bean(name = "utilisateurDataSource")
	  @ConfigurationProperties(prefix = "utilisateur.datasource")
	  public DataSource dataSource() {
	    return DataSourceBuilder.create().build();
	  }
	  
	  @Primary
	  @Bean(name = "utilisateurEntityManagerFactory")
	  public LocalContainerEntityManagerFactoryBean 
	  entityManagerFactory(
	    EntityManagerFactoryBuilder builder,
	    @Qualifier("utilisateurDataSource") DataSource dataSource
	  ) {
	    return builder
	      .dataSource(dataSource)
	      .packages("com.utilisateur.model")
	      .persistenceUnit("utilisateur")
	      .build();
	  }
	    
	  @Primary
	  @Bean(name = "utilisateurTransactionManager")
	  public PlatformTransactionManager transactionManager(
	    @Qualifier("utilisateurEntityManagerFactory")
	    EntityManagerFactory 
	    utilisateurEntityManagerFactory
	  ) {
	    return new JpaTransactionManager(utilisateurEntityManagerFactory);
	  }*/
}