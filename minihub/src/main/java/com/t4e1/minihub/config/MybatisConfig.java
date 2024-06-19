package com.t4e1.minihub.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@MapperScan(basePackages = "com.t4e1.minihub", annotationClass = Mapper.class)
public class MybatisConfig {

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);

        Properties properties = new Properties();
        properties.setProperty("typeHandlers", "com.t4e1.minihub.config.ArrayTypeHandler");
        sessionFactory.setConfigurationProperties(properties);

        return sessionFactory.getObject();
    }
}
