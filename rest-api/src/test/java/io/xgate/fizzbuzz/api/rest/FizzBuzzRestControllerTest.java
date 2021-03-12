package io.xgate.fizzbuzz.api.rest;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import io.xgate.fizzbuzz.api.FizzBuzzService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.Validator;

@ExtendWith(MockitoExtension.class)
class FizzBuzzRestControllerTest {

  private MockMvc mockMvc;
  @Mock
  private FizzBuzzService fizzBuzzService;

  @BeforeEach
  void initController() {
    mockMvc = MockMvcBuilders.standaloneSetup(new FizzBuzzRestController(fizzBuzzService))
        .defaultRequest(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
        .setValidator(Mockito.mock(Validator.class))
        .alwaysDo(MockMvcResultHandlers.print())
        .build();
  }

  @ParameterizedTest
  @ValueSource(strings = {"/fizzbuzz", "/fizzbuzz?entry="})
  void noEntryOrEmptyReturnsOneToHundred(String endpoint) throws Exception {
    mockMvc.perform(get(endpoint)).andExpect(status().isOk());
    verify(fizzBuzzService).getFizzBuzz(1, 100);
  }

  @Test
  void allowsSingleEntry() throws Exception {
    mockMvc.perform(get("/fizzbuzz?entry=1")).andExpect(status().isOk());
    verify(fizzBuzzService).getFizzBuzz(new int[]{1});
  }

  @Test
  void allowsArrayOfEntries() throws Exception {
    mockMvc.perform(get("/fizzbuzz?entry=1,2")).andExpect(status().isOk());
    verify(fizzBuzzService).getFizzBuzz(new int[]{1, 2});
  }

  @Test
  void throwErrorIfEntryIsNotInteger() throws Exception {
    mockMvc.perform(get("/fizzbuzz?entry=s")).andExpect(status().isBadRequest());
  }
}
