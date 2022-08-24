package com.sofka.demo.services;

import com.sofka.demo.domain.CyclistModel;
import com.sofka.demo.domain.TeamModel;
import com.sofka.demo.repository.CyclistRepository;
import com.sofka.demo.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class CyclistService {
    TeamRepository teamRepository ;
    @Autowired
    CyclistRepository cyclistRepository;

    public ArrayList<CyclistModel> getCyclist(){
        return (ArrayList<CyclistModel>) cyclistRepository.findAll();
    }
    public CyclistModel saveCyclist(CyclistModel cyclist) {
        return cyclistRepository.save(cyclist);
    }
    public boolean deleteCyclist(Long id) {
        try {
            cyclistRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }
}
