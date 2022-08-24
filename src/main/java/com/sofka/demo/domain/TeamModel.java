package com.sofka.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "team")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" )
    private Long id;
    @Column(name = "name_team" ,length = 20,unique = false,nullable = true)
    private String nameTeam;
    @Column(name = "code_team" ,length = 5,unique = true,nullable = true)
    private String codeTeam;
   @ManyToOne
   @JoinColumn(name = "country", nullable = false)
    private CountryModel countryModel;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<CyclistModel> cyclists;
}
