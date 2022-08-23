package com.sofka.demo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "cyclist")
@Data
@NoArgsConstructor

public class CyclistModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name_cyclist" ,length = 20,unique = false,nullable = false)
    private String nameCyclist;
    @Column(name = "competitor_number" ,length = 5,unique = true,nullable = false)
    private String competitorNumber;
   @ManyToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "country", nullable = false)
   private Country country;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "team", nullable = false)
    private TeamModel team;
}
