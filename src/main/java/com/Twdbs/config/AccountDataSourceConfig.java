package com.Twdbs.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "accountEntityManagerFactory" , transactionManagerRef = "accountTransactionManagerFactory",
        basePackages = "com.Twdbs.accountdb.repository")
public class AccountDataSourceConfig {


    @Bean(name = "accountDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.accountdb.datasource")
    public DataSource accountDatasource(){
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "accountEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean accountEntityManagerFactory(EntityManagerFactoryBuilder builder ,
        @Qualifier("accountDataSource") DataSource accountDataSource){

        return  builder.dataSource(accountDataSource).
                packages("com.Twdbs.accountdb.entity").
                build();

    }

    @Bean(name = "accountTransactionManagerFactory")
    public PlatformTransactionManager accountTransactionManager(
            @Qualifier("accountEntityManagerFactory")EntityManagerFactory accountTransactionManagerFactory){

        return  new JpaTransactionManager(accountTransactionManagerFactory);

    }

}
