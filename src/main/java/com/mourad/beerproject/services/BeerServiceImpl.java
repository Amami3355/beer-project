package com.mourad.beerproject.services;

import com.mourad.beerproject.repositories.BeerRepository;
import com.mourad.beerproject.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepository;

    @Override
    public List<BeerDto> getBeers() {
        return beerRepository.getBeers();
    }
    @Override
    public Optional<BeerDto> getBeerById(UUID id) {
        return beerRepository.getBeerById(id);
    }

    @Override
    public BeerDto createBeer(BeerDto beerDto) {
        return beerRepository.createBeer(beerDto);
    }

    @Override
    public boolean updataBeerById(UUID id) {
        return false;
    }


}
