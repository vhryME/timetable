package com.epolsoft.dictionary;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dictionary {

    private Map<String, Map<Integer, String>> dictionaries;

}