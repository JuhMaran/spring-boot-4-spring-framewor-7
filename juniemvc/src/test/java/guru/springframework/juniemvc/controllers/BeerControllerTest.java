package guru.springframework.juniemvc.controllers;

import guru.springframework.juniemvc.entities.Beer;
import guru.springframework.juniemvc.services.BeerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    BeerService beerService;

    @Test
    void givenBeerPayload_whenCreateBeer_thenReturnCreatedBeer() throws Exception {
        Beer savedBeer = buildBeer(1);
        given(beerService.saveBeer(any(Beer.class))).willReturn(savedBeer);

        mockMvc.perform(post("/api/v1/beers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                  "beerName": "Galaxy Cat",
                                  "beerStyle": "IPA",
                                  "upc": "123456789012",
                                  "quantityOnHand": 12,
                                  "price": 19.99
                                }
                                """))
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", "http://localhost/api/v1/beers/1"))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.beerName").value("Galaxy Cat"));
    }

    @Test
    void givenExistingBeerId_whenGetBeerById_thenReturnBeer() throws Exception {
        given(beerService.findBeerById(1)).willReturn(Optional.of(buildBeer(1)));

        mockMvc.perform(get("/api/v1/beers/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.beerStyle").value("IPA"));
    }

    @Test
    void givenMissingBeerId_whenGetBeerById_thenReturnNotFound() throws Exception {
        given(beerService.findBeerById(99)).willReturn(Optional.empty());

        mockMvc.perform(get("/api/v1/beers/99"))
                .andExpect(status().isNotFound());
    }

    @Test
    void givenPersistedBeers_whenGetAllBeers_thenReturnBeerList() throws Exception {
        given(beerService.findAllBeers()).willReturn(List.of(buildBeer(1), buildBeer(2)));

        mockMvc.perform(get("/api/v1/beers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[1].id").value(2));
    }

    private Beer buildBeer(Integer id) {
        return Beer.builder()
                .id(id)
                .beerName("Galaxy Cat")
                .beerStyle("IPA")
                .upc("123456789012")
                .quantityOnHand(12)
                .price(new BigDecimal("19.99"))
                .build();
    }
}
