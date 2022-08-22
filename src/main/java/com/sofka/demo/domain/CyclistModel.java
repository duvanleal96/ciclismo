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
    @Column(unique = true,nullable = false)
    private long id;
    private String nameCyclist;
    private String competitorNumber;
    @ManyToOne
    @JoinColumn(name = "country", nullable = false)
    private Country countryOrigin;
    @ManyToOne
    @JoinColumn(name = "team", nullable = false)
    private TeamModel team;
}
