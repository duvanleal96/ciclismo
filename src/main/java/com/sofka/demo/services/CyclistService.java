package com.sofka.demo.services;

import com.sofka.demo.domain.CyclistModel;
import com.sofka.demo.repository.CyclistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CyclistService {
    @Autowired
    CyclistRepository cyclistRepository;

    public ArrayList<CyclistModel> obtenerCiclistas(){
        return (ArrayList<CyclistModel>) cyclistRepository.findAll();
    }

}
