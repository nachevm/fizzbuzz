package io.xgate.fizzbuzz.domain;

import java.util.SortedMap;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "fizzbuzz")
class FizzBuzzProperties {

  private SortedMap<Integer, String> map;
}
