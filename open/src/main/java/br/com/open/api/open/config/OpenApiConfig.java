package br.com.open.api.open.config;

import feign.form.FormEncoder;
import org.springframework.context.annotation.Bean;


public class OpenApiConfig {

    @Bean
    public FormEncoder encoder() {
        return new FormEncoder();
    }
}
