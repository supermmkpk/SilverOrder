package com.silverorder.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 외부 API 요청 RestTemplate 설정
 * @author 채기훈
 * @since JDK17 Eclipse Temurin
 */
@Configuration
public class RestTemplateConfig {

        @Bean
        public RestTemplate restTemplate() {
            return new RestTemplate();
        }

}
