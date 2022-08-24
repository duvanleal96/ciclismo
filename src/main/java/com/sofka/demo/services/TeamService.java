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
    CyclistRepository cyclistRepository;
    @Autowired
    TeamRepository teamRepository;
    public ArrayList<TeamModel> getTeams(){
        return (ArrayList<TeamModel>) teamRepository.findAll();
    }
    public TeamModel saveTeam(TeamModel teamModel) {
        return teamRepository.save(teamModel);
    }
    public boolean deleteTeam(Long id) {
        try {
            teamRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }
    public Optional<TeamModel> findCyclistByCodeTeam(String codeTeam){
        return teamRepository.findCyclistByCodeTeam(codeTeam);

    }
    public Optional<TeamModel> findTeamModelByCountryModel(String nameCountry){
        return teamRepository.findTeamModelByCountryModel(nameCountry);
    }


}
