package com.sofka.demo.controller;


import com.sofka.demo.domain.CyclistModel;
import com.sofka.demo.domain.TeamModel;
import com.sofka.demo.repository.TeamRepository;
import com.sofka.demo.services.CyclistService;
import com.sofka.demo.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@CrossOrigin
@RestController
public class TeamController {
    @Autowired
    TeamService teamService;
    Logger logger = Logger.getLogger(TeamController.class.getName());
    @GetMapping("/api/team")
    public ArrayList<TeamModel> getTeam(){
        return teamService.getTeams();
    }
    @PostMapping("/api/teamNew")
    public ResponseEntity<TeamModel> saveTeam(@Validated @RequestBody TeamModel newTeam){
        try {
            return ResponseEntity.ok(teamService.saveTeam(newTeam));
        }catch (Exception e){
            logger.info(e.getMessage());
            TeamModel message = new TeamModel();
            message.setId(Long.valueOf(e.getMessage()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }

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
    public ResponseEntity<TeamModel>findCyclistByCodeTeam(@PathVariable(name = "codeTeam") String codeTeam){
        Optional<TeamModel> ciclist = teamService.findCyclistByCodeTeam(codeTeam);
        if(ciclist.isPresent())
            return ResponseEntity.ok().body(ciclist.get());
        else
            return ResponseEntity.notFound().build();
    }
}
