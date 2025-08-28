package com.lcwd.user.User.Service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class InterserviceComm {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
