package com.mourad.beerproject.repositories;

import com.mourad.beerproject.web.model.BeerDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BeerRepository {

    List<BeerDto> getBeers();
    Optional<BeerDto> getBeerById(UUID id);

    BeerDto createBeer(BeerDto beerDto);
}
