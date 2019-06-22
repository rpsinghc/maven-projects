package com.examples.jsf.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="com.examples.jsf")
public class SpringCoreConfig {
//    @Bean
//    public UserManagementDAO userManagementDAO() {
//        return new UserManagementDAOImpl();
//    }
}
