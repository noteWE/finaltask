package com.example.finaltask.configs;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.Formatter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Configuration
public class WebConfig extends WebMvcAutoConfiguration {
    @Bean
    public Formatter<LocalDateTime> localDateTimeFormatter() {
        return new Formatter<>() {

            @Override
            public String print(LocalDateTime localDateTime, Locale locale) {
                return DateTimeFormatter.ISO_DATE_TIME.format(localDateTime);
            }

            @Override
            public LocalDateTime parse(String s, Locale locale) throws ParseException {
                return LocalDateTime.parse(s, DateTimeFormatter.ISO_DATE_TIME);
            }
        };
    }
}
