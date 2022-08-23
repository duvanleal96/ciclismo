package com.sofka.demo.controller;

import com.sofka.demo.domain.CyclistModel;
import com.sofka.demo.services.CyclistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@CrossOrigin
@RestController
public class CyclistController {
    @Autowired
    CyclistService cyclistService;

    @GetMapping("/api/cyclist")
    public ArrayList<CyclistModel> getCyclist(){
        return cyclistService.getCyclist();
    }

    @PostMapping("/api/cyclistNew")
    public CyclistModel saveCyclist(@Validated @RequestBody CyclistModel cyclistNew){
        return  cyclistService.saveCyclist(cyclistNew);
    }
    @DeleteMapping(path = "/api/cyclist/delete/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        boolean ok = this.cyclistService.deleteCyclist(id);
        if (ok) {
            return "Se eliminó el el ciclista con id " + id;
        } else {
            return "No pudo eliminar el ciclista con id" + id;
        }
    }
}
