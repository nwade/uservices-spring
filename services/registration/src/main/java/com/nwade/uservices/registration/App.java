package com.nwade.uservices.registration;

import com.nwade.uservices.accounts.AccountController;
import com.nwade.uservices.accounts.RegistrationController;
import com.nwade.uservices.projects.ProjectController;
import com.nwade.uservices.schema.MigrationsDataSource;
import com.nwade.uservices.users.UserController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.sql.DataSource;

@SpringBootApplication
@ComponentScan(basePackageClasses = {
        UserController.class,
        AccountController.class,
        RegistrationController.class,
        ProjectController.class
})
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
