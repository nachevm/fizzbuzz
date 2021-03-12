package io.xgate.fizzbuzz.api;

import lombok.NonNull;

public interface FizzBuzzService {

  String[] getFizzBuzz(@NonNull int[] entries);

  String[] getFizzBuzz(int rangeStart, int rangeEnd);
}
