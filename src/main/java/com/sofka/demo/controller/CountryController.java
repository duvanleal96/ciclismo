package com.sofka.demo.controller;

import com.sofka.demo.domain.Country;
import com.sofka.demo.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Country saveCountry(@RequestBody Country country){
        return this.countryService.saveCountry(country);
    }
    @DeleteMapping(path = "/api/country/delete/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        boolean ok = this.countryService.deleteCountry(id);
        if (ok) {
            return "Se eliminó el el pais con id " + id;
        } else {
            return "No pudo eliminar el pais con id" + id;
        }
    }

}
