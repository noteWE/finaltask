package com.example.finaltask.configs;

import com.example.finaltask.exceptions.InvalidQueryDataFormatException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.Formatter;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

@Configuration
@Slf4j
public class WebConfig {
    @Bean
    public Formatter<LocalDateTime> localDateTimeFormatter() {
        return new Formatter<>() {

            @Override
            public String print(LocalDateTime localDateTime, Locale locale) {
                return DateTimeFormatter.ISO_DATE_TIME.format(localDateTime);
            }

            @Override
            public LocalDateTime parse(String s, Locale locale) {
                try {
                    return LocalDateTime.parse(s, DateTimeFormatter.ISO_DATE_TIME);
                } catch (DateTimeParseException exception) {
                    log.info(String.format("Invalid date-time format, value: %s", s));
                    throw new InvalidQueryDataFormatException(String.format("Invalid date-time format, value: %s", s));
                }
            }
        };
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}
