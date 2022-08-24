package com.sofka.demo.serviceTest;

import com.sofka.demo.domain.CountryModel;
import com.sofka.demo.domain.CyclistModel;
import com.sofka.demo.domain.TeamModel;
import com.sofka.demo.services.CyclistService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class TeamServicesTest {
    @Autowired
    CyclistService cyclistService;
    //ToDo Corregir test
    @Test
    public void testSaveCyclist() throws IllegalAccessException {
        CyclistModel cyclistModel = new CyclistModel(1l,"duvan enrique leal","123",
                new CountryModel(1l,"colombia",new ArrayList<>(),new ArrayList<>()),
                new TeamModel(1l,"akastuki","123",new CountryModel(),new ArrayList<>()));
        CyclistModel cyclistCreated = cyclistService.saveCyclist(cyclistModel);
        assertNotNull(cyclistCreated);
    }
}
