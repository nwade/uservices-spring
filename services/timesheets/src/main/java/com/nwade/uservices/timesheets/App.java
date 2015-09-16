package com.nwade.uservices.timesheets;

import com.nwade.uservices.schema.MigrationsDataSource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    CommandLineRunner migrate(DataSource dataSource) {
        return args -> {
            MigrationsDataSource migrations = new MigrationsDataSource(dataSource);
            migrations.tryMigrations();
        };
    }
}
