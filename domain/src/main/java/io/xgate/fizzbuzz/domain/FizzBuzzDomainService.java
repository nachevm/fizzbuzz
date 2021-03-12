package io.xgate.fizzbuzz.domain;

import io.xgate.fizzbuzz.api.FizzBuzzService;
import java.util.Arrays;
import java.util.Map.Entry;
import java.util.stream.IntStream;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class FizzBuzzDomainService implements FizzBuzzService {

  private final FizzBuzzProperties fizzBuzzProperties;

  @Override
  public String[] getFizzBuzz(int[] entries) {
    return Arrays.stream(entries).mapToObj(this::getFizzBuzz).toArray(String[]::new);
  }

  @Override
  public String[] getFizzBuzz(int rangeStart, int rangeEnd) {
    return IntStream.rangeClosed(rangeStart, rangeEnd).mapToObj(this::getFizzBuzz).toArray(String[]::new);
  }

  private String getFizzBuzz(int i) {
    final StringBuilder stringBuilder = new StringBuilder();
    for (Entry<Integer, String> entry : fizzBuzzProperties.getMap().entrySet()) {
      if (i % entry.getKey() == 0) {
        stringBuilder.append(entry.getValue());
      }
    }
    return stringBuilder.length() > 0 ? stringBuilder.toString() : String.valueOf(i);
  }
}
