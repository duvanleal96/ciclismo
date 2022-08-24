package com.sofka.demo.services;

import com.sofka.demo.domain.CountryModel;
import com.sofka.demo.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CountryService {
    @Autowired
    CountryRepository countryRepository;

    public ArrayList<CountryModel> getCountry(){
        return (ArrayList<CountryModel>) countryRepository.findAll();
    }
    public CountryModel saveCountry(CountryModel countryModel) {
        return countryRepository.save(countryModel);
    }
    public boolean deleteCountry(Long id) {
        try {
            countryRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }
    public Optional<CountryModel>findTeamModelByCountryModel(String nameCountry){
        return countryRepository.findTeamModelByNameCountry(nameCountry);
    }

}
