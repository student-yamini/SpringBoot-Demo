package com.example.productlist;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyAppConfig {
    @Bean
    public Mycomponent mycomponent() {
        return new Mycomponent();
    }
}
