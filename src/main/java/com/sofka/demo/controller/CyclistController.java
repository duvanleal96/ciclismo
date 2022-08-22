package com.sofka.demo.controller;

import com.sofka.demo.domain.CyclistModel;
import com.sofka.demo.services.CyclistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/cyclist")
public class CyclistController {
    @Autowired
    CyclistService cyclistService;

}
