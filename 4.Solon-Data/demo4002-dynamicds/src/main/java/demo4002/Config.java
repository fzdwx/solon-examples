package demo4002;

import com.zaxxer.hikari.HikariDataSource;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;
import org.noear.solon.data.dynamicds.DynamicDataSource;

import javax.sql.DataSource;

@Configuration
public class Config {
    @Bean(name = "db1",typed = true)
    public DataSource db1(@Inject("${test.db1}") HikariDataSource ds) {
        return ds;
    }

    @Bean("db2")
    public DataSource db2(@Inject("${test.db2}") DynamicDataSource ds) {
        return ds;
    }
}

