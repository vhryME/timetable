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
@Table(name = "spell")
public class SpellJpa {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String key;

    private String description;

    private String icon;

    private Double cooldown;

    private Double manaCost;

}
