package com.amuse.frametwo.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * @ClassName SecondDataConfiguration
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/6/8 10:35
 * @Version 1.0
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "secondEntityManagerFactory",
        transactionManagerRef = "secondTransactionManager",
        basePackages = {"com.amuse.frametwo"}
)
public class SecondDataConfiguration {

    @Autowired
    private JpaProperties jpaProperties;

    @Bean(name = "secondDataSource")
    @ConfigurationProperties(prefix = "second.datasource")
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }

    /**
     * 基于JdbcTemplate例子
     * @param dataSource
     * @return
     */
    @Bean(name = "secondJdbcTemplate")
    public JdbcTemplate secondJdbcTemplate(
            @Qualifier("secondDataSource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    /**
     * EntityManager例子
     * @param builder
     * @param dataSource
     * @return
     */
    @Bean(name = "secondEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder,DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.amuse.frametwo")
                .properties(jpaProperties.getHibernateProperties(dataSource))
                .persistenceUnit("second")
                .build();
    }

    @Bean(name = "secondTransactionManager")
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

}
