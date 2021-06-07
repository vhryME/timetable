package com.epolsoft.dictionary;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
@RequiredArgsConstructor
class DictionaryService {

    private final DictionaryServiceLocator locator;


    public Map<String, Map<Long, String>> getAllDictionaries() {
        Map<String, Map<Long, String>> dictionary = new HashMap<>();

        locator.getDictionaryServices().values().forEach(dictionaryRegistry ->
                dictionary.put(dictionaryRegistry.getNameOfDictionary(), dictionaryRegistry.getAllDictionaries()));

        return dictionary;
    }


    public Map<Long, String> getAllDictionariesByName(String dictionaryName) {
        DictionaryUseCase<?> dictionaryUseCase = locator.getDictionaryService(dictionaryName);

        return dictionaryUseCase.getAllDictionaries();
    }


    public Map<Long, String> getDictionaryById(String dictionaryName, Long id) {
        DictionaryUseCase<?> dictionaryUseCase = locator.getDictionaryService(dictionaryName);

        return dictionaryUseCase.getDictionaryById(id);
    }


    public Map<Long, String> getDictionariesByName(String dictionaryName, String name, Long count) {
        DictionaryUseCase<?> dictionaryUseCase = locator.getDictionaryService(dictionaryName);

        return dictionaryUseCase.getDictionariesByName(name, count);
    }
}