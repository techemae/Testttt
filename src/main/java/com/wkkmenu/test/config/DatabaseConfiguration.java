package com.wkkmenu.test.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;


@Configuration
@PropertySource("classpath:/application.properties")
public class DatabaseConfiguration {
	private final String MYBATIS_CONFIG = "classpath:mybatis/mybatis.xml";
	
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public DataSource mysqlDataSource() {
        return DataSourceBuilder.create().build();
    }
    @Bean
    public SqlSessionFactory sqlSessionFactory(@Autowired @Qualifier("mysqlDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
         
        factoryBean.setConfigLocation(resolver.getResource(MYBATIS_CONFIG));
         
        return factoryBean.getObject();
    }
    @Bean
    public SqlSession sqlSession(@Autowired @Qualifier("sqlSessionFactory") SqlSessionFactory factory) {
        return new SqlSessionTemplate(factory);
    }
}
