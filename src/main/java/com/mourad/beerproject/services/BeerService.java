package com.mourad.beerproject.services;

import com.mourad.beerproject.web.model.BeerDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BeerService {
    Optional<BeerDto> getBeerById(UUID id);

    BeerDto createBeer(BeerDto beerDto);

    boolean updataBeerById(UUID id);

    List<BeerDto> getBeers();
}
