package com.n47.multitenancydemo.config.multitenancy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
//zoneee
    private final DataSourceProperties dataSourceProperties;

    public DataSourceConfig(DataSourceProperties dataSourceProperties) {
        this.dataSourceProperties = dataSourceProperties;
    }

    @Bean
    public DataSource dataSource() {
        TenantRoutingDataSource customDataSource = new TenantRoutingDataSource();
        customDataSource.setTargetDataSources(dataSourceProperties.getDataSources());
        return customDataSource;
    }

//    @PostConstruct
//    public void migrate() {
//        for (Object dataSource : dataSourceProperties.getDataSources().values()) {
//            DataSource source = (DataSource) dataSource;
//            Flyway flyway = Flyway.configure().dataSource(source).load();
//            flyway.migrate();
//        }
//    }
}