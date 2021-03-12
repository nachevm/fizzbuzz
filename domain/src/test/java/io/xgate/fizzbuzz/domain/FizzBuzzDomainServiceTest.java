package io.xgate.fizzbuzz.domain;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;

import java.util.Map;
import java.util.TreeMap;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FizzBuzzDomainServiceTest {

  @InjectMocks
  private FizzBuzzDomainService fizzBuzzDomainService;
  @Mock
  private FizzBuzzProperties fizzBuzzProperties;

  @Test
  void getFizzBuzz_nullNotAllowed() {
    assertThrows(NullPointerException.class, () -> fizzBuzzDomainService.getFizzBuzz(null));
  }

  @Test
  void getFizzBuzz_returnsFizzBuzzForAllEntries() {
    doReturn(getFuzzBuzzMap()).when(fizzBuzzProperties).getMap();

    assertArrayEquals(new String[]{"1", "Fizz", "4", "Fizz", "Buzz"}, fizzBuzzDomainService.getFizzBuzz(new int[]{1, 3, 4, 6, 10}));
  }

  @Test
  void getFizzBuzz_returnsFizzBuzzForOneToHundred() {
    doReturn(getFuzzBuzzMap()).when(fizzBuzzProperties).getMap();

    assertArrayEquals(
        new String[]{"1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz", "16", "17",
            "Fizz", "19", "Buzz", "Fizz", "22", "23", "Fizz", "Buzz", "26", "Fizz", "28", "29", "FizzBuzz", "31", "32", "Fizz", "34",
            "Buzz", "Fizz", "37", "38", "Fizz", "Buzz", "41", "Fizz", "43", "44", "FizzBuzz", "46", "47", "Fizz", "49", "Buzz", "Fizz",
            "52", "53", "Fizz", "Buzz", "56", "Fizz", "58", "59", "FizzBuzz", "61", "62", "Fizz", "64", "Buzz", "Fizz", "67", "68",
            "Fizz", "Buzz", "71", "Fizz", "73", "74", "FizzBuzz", "76", "77", "Fizz", "79", "Buzz", "Fizz", "82", "83", "Fizz", "Buzz",
            "86", "Fizz", "88", "89", "FizzBuzz", "91", "92", "Fizz", "94", "Buzz", "Fizz", "97", "98", "Fizz", "Buzz"},
        fizzBuzzDomainService.getFizzBuzz(1, 100)
    );
  }

  private Map<Integer, String> getFuzzBuzzMap() {
    Map<Integer, String> map = new TreeMap<>();
    map.put(3, "Fizz");
    map.put(5, "Buzz");
    return map;
  }
}
