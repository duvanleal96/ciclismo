package com.sofka.demo.controller;


import com.sofka.demo.domain.TeamModel;
import com.sofka.demo.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.stream.Stream;

@CrossOrigin
@RestController
public class TeamController {

    @Autowired
    TeamService teamService;
    @GetMapping("/api/team")
    public ArrayList<TeamModel> getTeam(){
        return teamService.getTeams();
    }
    @PostMapping("/api/teamNew")
    public TeamModel saveTeam(@Validated @RequestBody TeamModel newTeam){
        return  teamService.saveTeam(newTeam);
    }

    @DeleteMapping(path = "/api/team/delete/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        boolean ok = this.teamService.deleteTeam(id);
        if (ok) {
            return "Se eliminó el el equipo con id " + id;
        } else {
            return "No pudo eliminar el equipo con id " + id;
        }
    }
    @GetMapping("/api/team/codeTeam/{codeTeam}")
    public Stream<Long> getCyclistByCodeTeam(@PathVariable("codeTeam") String codeTeam){
         return teamService.findCyclistByCodeTeam(codeTeam);
    }
}
