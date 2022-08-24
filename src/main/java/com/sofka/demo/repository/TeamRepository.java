package com.sofka.demo.repository;

import com.sofka.demo.domain.CyclistModel;
import com.sofka.demo.domain.TeamModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface TeamRepository extends CrudRepository<TeamModel, Long> {

    public Optional<TeamModel> findCyclistByCodeTeam(String codeTeam);
}
