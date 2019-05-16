package business.config;

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
            ds.setDriverClass( "com.mysql.cj.jdbc.Driver" );
            ds.setJdbcUrl( "jdbc:mysql://119.29.221.246/chartroom?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true" );
            ds.setUser( "link" );
            ds.setPassword( "Admin@Pass001" );
            return ds;
        }
        catch (Exception e){
            throw new RuntimeException(  );
        }

    }

}
