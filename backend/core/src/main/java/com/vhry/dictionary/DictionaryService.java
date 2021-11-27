package com.vhry.dictionary;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class DictionaryService {

    private final DictionaryServiceLocator locator;


    public Map<String, Map<Long, String>> getAllDictionaries() {
        Map<String, Map<Long, String>> dictionaries = new HashMap<>();

        locator.getDictionaryServices().values().forEach(dictionaryUseCase ->
                dictionaries.put(
                        dictionaryUseCase.getNameOfDictionary(),
                        dictionaryUseCase.getAllDictionaries()));

        return dictionaries;
    }


    public Map<Long, String> getAllDictionariesByName(String dictionaryName) {
        return locator.getDictionaryService(dictionaryName).getAllDictionaries();
    }


    public Map<Long, String> getDictionaryById(String dictionaryName, Long id) {
        return locator.getDictionaryService(dictionaryName).getDictionaryById(id);
    }

}
