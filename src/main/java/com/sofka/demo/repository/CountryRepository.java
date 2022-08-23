package com.sofka.demo.repository;

import com.sofka.demo.domain.Country;
import com.sofka.demo.domain.CyclistModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {
    //public Optional<CountryRepository> findCyclistByCountry(String nameCountry);
}
