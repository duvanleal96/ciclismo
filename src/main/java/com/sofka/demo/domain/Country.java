package com.sofka.demo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "country")
@Data
@NoArgsConstructor

public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = true)
    private Long id;    private String nameCountry;
}

