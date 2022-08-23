package com.sofka.demo.repository;


import com.sofka.demo.domain.CyclistModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CyclistRepository extends CrudRepository<CyclistModel, Long> {
}
