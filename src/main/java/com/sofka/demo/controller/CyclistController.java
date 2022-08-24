package com.sofka.demo.controller;

import com.sofka.demo.domain.CyclistModel;
import com.sofka.demo.domain.TeamModel;
import com.sofka.demo.services.CyclistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;
import java.util.logging.Logger;

@CrossOrigin
@RestController
public class CyclistController {
    @Autowired
    CyclistService cyclistService;
    Logger logger = Logger.getLogger(TeamController.class.getName());
    @GetMapping("/api/cyclist")
    public ArrayList<CyclistModel> getCyclist(){
        return cyclistService.getCyclist();
    }

    @PostMapping("/api/cyclistNew")
    public ResponseEntity<CyclistModel> saveTeam(@Validated @RequestBody CyclistModel newCyclist){
        try {
            return ResponseEntity.ok(cyclistService.saveCyclist(newCyclist));
        }catch (Exception e){
            logger.info(e.getMessage());
            CyclistModel message = new CyclistModel();
            message.setId(Long.valueOf(e.getMessage()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }

    }
    @DeleteMapping(path = "/api/cyclist/delete/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        boolean ok = this.cyclistService.deleteCyclist(id);
        if (ok) {
            return "Se eliminó el el ciclista con id " + id;
        } else {
            return "No pudo eliminar el ciclista con id " + id;
        }
    }

}
