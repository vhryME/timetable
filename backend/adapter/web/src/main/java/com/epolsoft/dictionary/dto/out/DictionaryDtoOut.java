package com.epolsoft.dictionary.dto.out;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Map;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class DictionaryDtoOut {

    @NotNull
    private Map<String, Map<Integer, String>> dictionaries;

}