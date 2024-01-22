package com.mourad.beerproject.web.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mourad.beerproject.services.BeerService;
import com.mourad.beerproject.web.model.BeerDto;
import com.mourad.beerproject.web.model.BeerStyle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    private BeerService beerService;



    @Test
    void getBeers() {



    }

    @Test
    void getBeerById() throws Exception {
        // given
        UUID id = UUID.randomUUID();
        BeerDto expected = BeerDto.builder().id(id).beerName("name").build();
        // when
        doReturn(Optional.of(expected)).when(beerService).getBeerById(id);
        // then
        mockMvc.perform(get("/api/v1/beer/" + id)
                .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }

    @Test
    void createBeer() throws Exception {

        // given
        BeerDto beer = BeerDto.builder().id(UUID.randomUUID()).beerName("beer 1").style(BeerStyle.ALE).build();
        String strBeer = objectMapper.writeValueAsString(beer);
        // when

        doReturn(beer).when(beerService).createBeer(beer);
        // then
        mockMvc.perform(post("/api/v1/beer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(strBeer)
        ).andExpect(status().isCreated()).andExpect(content().json(strBeer));

    }

    @Test
    void updateBeerById() throws Exception {
        // Given
        UUID id = UUID.randomUUID();
        BeerDto beerToUpdate = BeerDto.builder().id(id).beerName("Updated Beer").build();
        String beerToUpdateJson = objectMapper.writeValueAsString(beerToUpdate);
        // when
        doReturn(true).when(beerService).updateBeerById(id, beerToUpdate);
        // then
        mockMvc.perform(put("/api/v1/beer/" + id.toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(beerToUpdateJson))
                .andExpect(status().isAccepted());
    }
}