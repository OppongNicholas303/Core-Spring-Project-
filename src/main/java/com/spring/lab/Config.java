package com.spring.lab;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public MyfirstClass myfirstClass (){
        return new MyfirstClass("samo");
    }

}
