package com.sofka.demo.repository;

import com.sofka.demo.domain.TeamModel;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface TeamRepository {
   public Optional<TeamModel> findCyclistByCodeTeam(String codeTeam);
}
