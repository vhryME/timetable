package com.vhry.dictionary;

import com.vhry.util.Maps;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public interface DictionaryUseCase<Dict extends Dictionary> {

    DictionaryPort<Dict> getDictionaryPort();


    default Map<Long, String> getAllDictionaries() {
        return getDictionaryPort().findAll()
                .stream()
                .collect(Collectors.toMap(Dict::getId, Dict::getValue));
    }

    default Map<Long, String> getDictionaryById(Long id) {
        Dict dict = getDictionaryPort().findById(id);

        return Maps.<Long, String>builder().put(dict.getId(), dict.getValue()).build();
    }

    String getNameOfDictionary();

}
