package com.itheima.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;

public class jdbcConfig {

    @Bean(name = "runner")
    @Scope("prototype")
    public QueryRunner creatQueryRunner(DataSource dataSource){
        return new QueryRunner(dataSource);
    }

    @Bean(name = "dataSource")
    public DataSource createDataSource(){
        try{
            ComboPooledDataSource ds=new ComboPooledDataSource(  );
            ds.setDriverClass( "com.mysql.jdbc.Driver" );
            ds.setJdbcUrl( "jdbc:mysql://localhost:3306/user" );
            ds.setUser( "root" );
            ds.setPassword( "123456" );
            return ds;
        }
        catch (Exception e){
            throw new RuntimeException(  );
        }

    }

}
