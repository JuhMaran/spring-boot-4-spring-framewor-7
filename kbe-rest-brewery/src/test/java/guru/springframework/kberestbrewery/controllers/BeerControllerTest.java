package guru.springframework.kberestbrewery.controllers;

import guru.springframework.kberestbrewery.bootstrap.BeerLoader;
import guru.springframework.kberestbrewery.model.BeerDto;
import guru.springframework.kberestbrewery.services.BeerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import java.util.UUID;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = BeerController.class)
class BeerControllerTest {

  @MockitoBean
  BeerService beerService;

  @Autowired
  MockMvc mockMvc;

  @Autowired
  ObjectMapper objectMapper;

  BeerDto validBeer;

  @BeforeEach
  void setUp() {
    validBeer = BeerDto.builder()
      .id(UUID.randomUUID())
      .beerName("Beer1")
      .beerStyle("PALE_ALE")
      .upc(BeerLoader.BEER_2_UPC)
      .build();
  }

  @Test
  void getBeer() throws Exception {
    given(beerService.getById(any(UUID.class), any())).willReturn(validBeer);

    mockMvc.perform(get("/api/v1/beer/" + validBeer.id().toString()).accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
      .andExpect(jsonPath("$.id", is(validBeer.id().toString())))
      .andExpect(jsonPath("$.beerName", is("Beer1")));
  }

  @Test
  void handlePost() throws Exception {
    //given
    BeerDto beerDto = validBeer.toBuilder()
      .id(null)
      .build();

    BeerDto savedDto = BeerDto.builder()
      .id(UUID.randomUUID())
      .beerName("New Beer")
      .build();
    String beerDtoJson = objectMapper.writeValueAsString(beerDto);

    given(beerService.saveNewBeer(any())).willReturn(savedDto);

    mockMvc.perform(post("/api/v1/beer")
        .contentType(MediaType.APPLICATION_JSON)
        .content(beerDtoJson))
      .andExpect(status().isCreated());

  }

  @Test
  void handleUpdate() throws Exception {
    //given
    BeerDto beerDto = validBeer.toBuilder()
      .id(null)
      .build();

    String beerDtoJson = objectMapper.writeValueAsString(beerDto);

    //when
    mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID())
        .contentType(MediaType.APPLICATION_JSON)
        .content(beerDtoJson))
      .andExpect(status().isNoContent());

    then(beerService).should().updateBeer(any(), any());

  }

}