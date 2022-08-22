package com.sofka.demo.repository;

import java.util.Optional;

public interface CountryRepository {
    public Optional<CountryRepository> findCyclistByCountry(String nameCountry);
}
