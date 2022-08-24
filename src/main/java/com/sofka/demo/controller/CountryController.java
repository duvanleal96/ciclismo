package com.sofka.demo.controller;

import com.sofka.demo.domain.CountryModel;
import com.sofka.demo.domain.CyclistModel;
import com.sofka.demo.domain.TeamModel;
import com.sofka.demo.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class CountryController {

    @Autowired
    CountryService countryService;
    @GetMapping("/api/country")
    public ArrayList<CountryModel> getCountry(){
        return countryService.getCountry();
    }

    @PostMapping("/api/newCountry")
    public CountryModel saveCountry(@RequestBody CountryModel countryModel){
        return this.countryService.saveCountry(countryModel);
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
    @GetMapping("/api/country/countryTeam/{nameCountry}")
    public List<TeamModel> findTeamModelByCountryModel(@PathVariable(name = "nameCountry") String nameCountry){
        Optional<CountryModel> team = countryService.findTeamModelByCountryModel(nameCountry);
            return team.get().getTeams();
    }

    @GetMapping("/api/country/countryCyclist/{nameCountry}")
    public List<CyclistModel> findCyclistModelByCountryModel(@PathVariable(name = "nameCountry") String nameCountry){
        Optional<CountryModel> team = countryService.findTeamModelByCountryModel(nameCountry);
        return team.get().getCyclists();
    }


}
