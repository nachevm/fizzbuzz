package io.xgate.fizzbuzz.api.rest;

import io.xgate.fizzbuzz.api.FizzBuzzService;
import java.util.Arrays;
import lombok.RequiredArgsConstructor;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class FizzBuzzRestController {

  private final FizzBuzzService fizzBuzzService;

  @GetMapping("/fizzbuzz")
  public String getFizzBuzz(@RequestParam(required = false, name = "entry") int[] entries) {
    return Arrays.toString(
        ObjectUtils.isEmpty(entries) ? fizzBuzzService.getFizzBuzz(1, 100) : fizzBuzzService.getFizzBuzz(entries)
    );
  }
}
