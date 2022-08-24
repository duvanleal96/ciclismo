package com.sofka.demo.services;

import com.sofka.demo.domain.CyclistModel;
import com.sofka.demo.domain.TeamModel;
import com.sofka.demo.repository.CyclistRepository;
import com.sofka.demo.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class TeamService {
    @Autowired
    TeamRepository teamRepository;
    public ArrayList<TeamModel> getTeams(){
        return (ArrayList<TeamModel>) teamRepository.findAll();
    }
    public TeamModel saveTeam(TeamModel teamModel) throws IllegalAccessException {
        if(teamModel.getCodeTeam().length()<=3) {
            return teamRepository.save(teamModel);
        }
        throw new IllegalAccessException("el codigo de equipo debe tener el maximo 3 caracteres");
    }
    public boolean deleteTeam(Long id) {
        try {
            teamRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }
    public Optional<TeamModel>findCyclistByCodeTeam(String codeTeam){
        return teamRepository.findCyclistByCodeTeam(codeTeam);
    }

}
