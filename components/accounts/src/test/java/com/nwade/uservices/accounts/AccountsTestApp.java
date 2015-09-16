package com.nwade.uservices.accounts;

import com.nwade.uservices.users.UserRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = {UserRepository.class, RegistrationService.class})
public class AccountsTestApp {
}
