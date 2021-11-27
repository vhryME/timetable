package com.vhry.dictionary;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class DictionaryDtoOut {

    @NotNull
    private Long id;

    @NotBlank
    private String value;

}
