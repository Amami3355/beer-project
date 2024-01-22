package com.mourad.beerproject.web.controllers;

import com.mourad.beerproject.services.BeerService;
import com.mourad.beerproject.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer")
@RequiredArgsConstructor
public class BeerController {

    private final BeerService beerService;

    @GetMapping
    public ResponseEntity<List<BeerDto>> getBeers(){
        return new ResponseEntity<>(beerService.getBeers(), HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable UUID id) {
        return beerService.getBeerById(id).map(beerDto -> ResponseEntity.ok().body(beerDto)).
                orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createBeer(@RequestBody BeerDto beerDto){


        return new ResponseEntity<>(beerService.createBeer(beerDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBeerById(@RequestBody BeerDto beerToUpdate, @PathVariable UUID id){
        if (beerService.updateBeerById(id, beerToUpdate)){
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }




}
