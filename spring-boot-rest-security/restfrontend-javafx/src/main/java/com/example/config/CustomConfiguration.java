package com.example.config;

import com.example.utils.CustomHttpHeaders;
import com.example.utils.CustomRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

/**
 * Created by Nijat Aghayev on 30.05.19.
 */
@Configuration
public class CustomConfiguration {
    @Bean
    RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(Collections.singletonList(new MappingJackson2HttpMessageConverter()));
        restTemplate.setInterceptors(Collections.singletonList(interceptor()));
        return restTemplate;
    }

    @Bean
    ClientHttpRequestInterceptor interceptor() {
        return (httpRequest, bytes, clientHttpRequestExecution) -> {
          httpRequest.getHeaders().set(HttpHeaders.CONTENT_TYPE, "application/json");
          if(CustomRegistry.getAccessToken() != null && !CustomRegistry.getAccessToken().isEmpty()) {
              httpRequest.getHeaders().set(CustomHttpHeaders.ACCESS_TOKEN, "Bearer "+ CustomRegistry.getAccessToken());
          }
          return clientHttpRequestExecution.execute(httpRequest, bytes);
        };
    }
}
