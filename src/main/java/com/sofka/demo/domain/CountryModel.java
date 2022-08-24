package com.sofka.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "country")
@Data
@NoArgsConstructor

public class CountryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name_country" ,length = 20,unique = false,nullable = false)
     private String nameCountry;
    @OneToMany(mappedBy = "countryModel", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<CyclistModel> cyclists;
    @OneToMany(mappedBy = "countryModel", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<TeamModel> teams;
}

