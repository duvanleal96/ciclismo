package com.sofka.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "cyclist")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CyclistModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name_cyclist" ,length = 20,unique = false,nullable = false)
    private String nameCyclist;
    @Column(name = "competitor_number" ,length = 5,unique = true,nullable = false)
    private String competitorNumber;
   @ManyToOne
   @JoinColumn(name = "country", nullable = true)
   private CountryModel countryModel;
    @ManyToOne
    @JoinColumn(name = "team", nullable = true)
    private TeamModel team;
}
