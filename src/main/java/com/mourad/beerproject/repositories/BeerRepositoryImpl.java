package com.mourad.beerproject.repositories;

import com.mourad.beerproject.web.model.BeerDto;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class BeerRepositoryImpl implements BeerRepository{
    private final List<BeerDto> beers = new ArrayList<>();


    @Override
    public List<BeerDto> getBeers() {
        return beers;
    }

    @Override
    public Optional<BeerDto> getBeerById(UUID id) {
        return beers.stream().filter(beerDto -> beerDto.getId().equals(id)).findFirst();
    }

    @Override
    public BeerDto createBeer(BeerDto beerDto) {
        beerDto.setId(UUID.randomUUID());
        beers.add(beerDto);
        return beerDto;
    }
}
