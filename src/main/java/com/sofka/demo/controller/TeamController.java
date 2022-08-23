package com.sofka.demo.controller;


import com.sofka.demo.domain.TeamModel;
import com.sofka.demo.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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
}
