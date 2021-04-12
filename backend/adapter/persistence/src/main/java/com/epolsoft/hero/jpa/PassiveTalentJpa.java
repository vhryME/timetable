package com.epolsoft.hero.jpa;

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
@Table(name = "passiveTalents")
public class PassiveTalentJpa extends TalentJpa {

    @Id
    @GeneratedValue
    private Long id;

    private String skill;

}
