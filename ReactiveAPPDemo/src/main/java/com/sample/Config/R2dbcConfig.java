package com.sample.Config;

import io.r2dbc.pool.ConnectionPool;
import io.r2dbc.pool.ConnectionPoolConfiguration;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactoryOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static io.r2dbc.spi.ConnectionFactoryOptions.*;

import java.time.Duration;

@Configuration
public class R2dbcConfig {

    @Bean
    public ConnectionFactory connectionFactory() {
        ConnectionFactoryOptions options = ConnectionFactoryOptions.builder()
            .option(DRIVER, "mysql")
            .option(HOST, "localhost")
            .option(PORT, 3306)
            .option(USER, "root")
            .option(PASSWORD, "123456")
            .option(DATABASE, "sampleDB")
            .build();

        ConnectionFactory connectionFactory = ConnectionFactories.get(options);

        ConnectionPoolConfiguration config = ConnectionPoolConfiguration.builder(connectionFactory)
        		.maxIdleTime(Duration.ofMinutes(5))        // lower max idle time
        	    .maxLifeTime(Duration.ofMinutes(30))       // max connection lifetime
        	    .initialSize(5)
        	    .maxSize(20)
        	    .build();

        return new ConnectionPool(config);
    }
}