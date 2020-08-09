package cn.lhx.springcloud.config;

import com.alibaba.druid.pool.DruidDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * seata分布式事务代理数据源
 * @author lee549
 * @date 2020/8/4 12:33
 */
@Configuration
public class SeataConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }

    @Primary
    @Bean("dataSource")
    public DataSourceProxy dataSource(DataSource druidDataSource){
        return new DataSourceProxy(druidDataSource);
    }
}
