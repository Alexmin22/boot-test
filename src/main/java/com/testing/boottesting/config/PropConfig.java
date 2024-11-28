package com.testing.boottesting.config;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.Arrays;
import java.util.List;

@Getter
@ToString
@Component
@Setter
@Validated
@ConfigurationProperties(prefix = "prop.config.redis")
public class PropConfig {

    @NotBlank
    private String host;
    @Positive
    @Max(9999)
    private int port;

    private List<String> list = Arrays.asList("1", "2", "3");   //default value
}

