package com.sofka.demo.controller;

import com.sofka.demo.domain.Country;
import com.sofka.demo.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin
@RestController
public class CountryController {

    @Autowired
    CountryService countryService;
    @GetMapping("/api/country")
    public ArrayList<Country> getCountry(){
        return countryService.getCountry();
    }

    @PostMapping("/api/newCountry")
    public Country saveCountry(@Validated @RequestBody Country country){
        return  countryService.saveCountry(country);
    }
}
