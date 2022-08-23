package com.sofka.demo.services;

import com.sofka.demo.domain.Country;
import com.sofka.demo.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CountryService {
    @Autowired
    CountryRepository countryRepository;

    public ArrayList<Country> getCountry(){
        return (ArrayList<Country>) countryRepository.findAll();
    }
    public Country saveCountry(Country country) {
        return countryRepository.save(country);
    }
}
