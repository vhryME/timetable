package com.epolsoft.hero.dto.out;


import com.epolsoft.hero.domain.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class FullHeroDtoOut {

    @NotNull
    private Long id;

    @NotNull
    private String name;

    private String icon;

    @NotNull
    private Integer roleId;

    @NotNull
    private Boolean isMelee;

    @NotNull
    private String dateOfCreation;

    private String status;

    @NotNull
    @Valid
    @Size(min = 5)
    private Set<SpellDtoOut> spells;

    @NotNull
    @Valid
    private Set<TalentDtoOut> talents;

}