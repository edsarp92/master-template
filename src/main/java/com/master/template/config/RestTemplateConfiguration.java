package com.master.template.config;

import org.springframework.context.annotation.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
/**
 * Created by edsarp on 11/14/16.
 */
@Configuration
public class RestTemplateConfiguration {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate(Collections.<HttpMessageConverter<?>>singletonList(new MappingJackson2HttpMessageConverter()));
    }
}
