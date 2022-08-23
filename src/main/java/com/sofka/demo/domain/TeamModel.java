package com.sofka.demo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "team")
@Data
@NoArgsConstructor
public class TeamModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" )
    private Long id;
    @Column(name = "name_team" ,length = 20,unique = false,nullable = false)
    private String nameTeam;
    @Column(name = "code_team" ,length = 5,unique = true,nullable = false)
    private String codeTeam;
    @ManyToOne
    @JoinColumn(name = "country", nullable = false)
    private Country country;

}
