package guru.springframework.spring7restmvc.controller;

import guru.springframework.spring7restmvc.services.BeerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
//@SpringBootTest
class BeerControllerTest {

  @Autowired
  MockMvc mockMvc;

  @MockitoBean
  BeerService beerService;

//  @Autowired
//  BeerController beerController;

  @Test
  void getBeerById() throws Exception {
//    System.out.println(beerController.getBeerById(UUID.randomUUID()));
    mockMvc.perform(get("" + UUID.randomUUID())
        .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk());
  }

}