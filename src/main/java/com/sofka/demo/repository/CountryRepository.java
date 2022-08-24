package com.sofka.demo.repository;

import com.sofka.demo.domain.CountryModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface CountryRepository extends CrudRepository<CountryModel, Long> {
    Optional<CountryModel> findCountryById(String id);
    Optional<CountryModel> findCyclistByNameCountry(String nameCountry);
    ArrayList<CountryModel> findTeamByNameCountry(String nameCountry);
}
