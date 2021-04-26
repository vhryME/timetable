package com.epolsoft.dictionary;


import com.epolsoft.dictionary.locator.DictionaryServiceLocator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@RequiredArgsConstructor
class DictionaryService {

    private final DictionaryServiceLocator locator;


    public Dictionary getAllDictionaries() {
        Dictionary dictionaryComposite = new Dictionary();
        Map<String, Map<Integer, String>> dictionary = new HashMap<>();

        locator.getDictionaryServices().values().forEach(dictionaryRegistry ->
                dictionary.put(dictionaryRegistry.getNameOfDictionary(), dictionaryRegistry.getAllDictionaries()));

        dictionaryComposite.setDictionaries(dictionary);

        return dictionaryComposite;
    }


    public Dictionary getAllDictionariesByName(String dictionaryName) {
        Dictionary dictionaryComposite = new Dictionary();
        Map<String, Map<Integer, String>> dictionary = new HashMap<>();
        DictionaryUseCase<?> dictionaryUseCase = locator.getDictionaryService(dictionaryName);

        dictionary.put(dictionaryUseCase.getNameOfDictionary(), dictionaryUseCase.getAllDictionaries());
        dictionaryComposite.setDictionaries(dictionary);

        return dictionaryComposite;
    }


    public Object getDictionaryById(String dictionaryName, Integer id) {
        DictionaryUseCase<?> dictionaryUseCase = locator.getDictionaryService(dictionaryName);

        return dictionaryUseCase.getDictionaryById(id);
    }


    public List getDictionariesByName(String dictionaryName, String name, Long count) {
        DictionaryUseCase<?> dictionaryUseCase = locator.getDictionaryService(dictionaryName);

        return dictionaryUseCase.getDictionariesByName(name, count);
    }
}