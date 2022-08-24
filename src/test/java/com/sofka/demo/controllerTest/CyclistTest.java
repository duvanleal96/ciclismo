package com.sofka.demo.controllerTest;

import com.sofka.demo.repository.CyclistRepository;
import com.sofka.demo.services.CyclistService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CyclistTest {
    @MockBean
    CyclistRepository cyclistRepository;

    @Autowired
    CyclistService cyclistService;
    //Test Complete!
    @Test
    public void testSaveCyclist(){
       when(cyclistRepository.findAll()).thenReturn(new ArrayList<>());
        assertThat(cyclistService.getCyclist()).isEmpty();
        verify(cyclistRepository).findAll();
    }
}

