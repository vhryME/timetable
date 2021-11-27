package com.vhry.dictionary;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class DictionaryDtoIn {

    @NotNull
    @Min(1)
    private Long id;

    private String value;

}
