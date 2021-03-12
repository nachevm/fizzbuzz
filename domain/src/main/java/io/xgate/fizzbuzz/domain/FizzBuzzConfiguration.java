package io.xgate.fizzbuzz.domain;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/fizzbuzz.properties")
@EnableConfigurationProperties(FizzBuzzProperties.class)
class FizzBuzzConfiguration {

}
