package br.com.open.api.open.config;

import feign.form.FormEncoder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Configuration
public class OpenInitialize {

    private static final Logger LOGGER = LoggerFactory.getLogger(OpenInitialize.class);

    @Bean
    public FormEncoder encoder() {
        return new FormEncoder();
    }

    @Bean
    @Order(1)
    public CommandLineRunner initialize() {
        return (args) -> {
            LOGGER.info("-------------SUBIU-------------");
            LOGGER.info(String.valueOf(new Date()).concat(new Locale(" pt", "BR").toString()));
        };
    }
}
