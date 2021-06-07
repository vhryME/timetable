package com.epolsoft.hero.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "passive_talent")
public class PassiveTalentJpa extends TalentJpa {

    @Column(name = "spell_uuid")
    private String spell;

}
