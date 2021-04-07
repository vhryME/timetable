package com.epolsoft.dto.hero;

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
@Table(name = "talent")
public class TalentJpa {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    private String icon;

    private String key;

    private Integer levelOfAccess;

}
