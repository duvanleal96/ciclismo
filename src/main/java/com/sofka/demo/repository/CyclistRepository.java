package com.sofka.demo.repository;


import com.sofka.demo.domain.CyclistModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CyclistRepository extends CrudRepository<CyclistModel, Long> {
    public Optional<CyclistModel> getCyclistModelById(String id);

}
