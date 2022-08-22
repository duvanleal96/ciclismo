package com.sofka.demo.services;

import com.sofka.demo.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Service
public class TeamService {
    @Autowired
    TeamRepository teamRepository;
}
