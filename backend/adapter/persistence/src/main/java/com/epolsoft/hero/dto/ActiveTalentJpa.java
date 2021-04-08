package com.epolsoft.hero.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "activeTalent")
public class ActiveTalentJpa extends TalentJpa {

    @Id
    @GeneratedValue
    private Long id;

    private Double cost;

    private Double timeOfRecovery;

}
