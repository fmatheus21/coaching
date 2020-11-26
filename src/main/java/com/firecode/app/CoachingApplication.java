package com.firecode.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class CoachingApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        System.out.println("Senha: " + new BCryptPasswordEncoder().encode("210683@"));
        SpringApplication.run(CoachingApplication.class, args);
    }

}
