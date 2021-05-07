package com.epolsoft.hero.dto.in;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        visible = true,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ActiveTalentDtoIn.class, name = "active"),
        @JsonSubTypes.Type(value = PassiveTalentDtoIn.class, name = "passive")
})
public class TalentDtoIn {

    @JsonProperty(value = "type")
    private String type;

    @NonNull
    private String name;

    private String description = "";

    private String icon = "";

    private String key = "";

    @NonNull
    private Integer levelOfAccess;

}
