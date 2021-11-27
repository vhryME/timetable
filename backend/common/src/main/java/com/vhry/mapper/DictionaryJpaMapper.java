package com.vhry.mapper;

import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public interface DictionaryJpaMapper<Dict, DictJpa> {

    Dict fromJpaDictionary(DictJpa jpaDictionary);


    default Page<Dict> fromJpaDictionaries(Page<DictJpa> jpaDictionaries) {
        return jpaDictionaries.map(this::fromJpaDictionary);
    }

    default List<Dict> fromJpaDictionaries(List<DictJpa> jpaDictionaries) {
        return jpaDictionaries.stream().map(this::fromJpaDictionary).collect(Collectors.toList());
    }
    
}
