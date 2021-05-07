package com.epolsoft.hero.dto.out;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        visible = true,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ActiveTalentDtoOut.class, name = "active"),
        @JsonSubTypes.Type(value = PassiveTalentDtoOut.class, name = "passive")
})
public class TalentDtoOut {

    @JsonProperty(value = "type")
    private String type;

    @NotNull
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private String icon;

    @NotNull
    private String key;

    @NotNull
    private Integer levelOfAccess;

}
