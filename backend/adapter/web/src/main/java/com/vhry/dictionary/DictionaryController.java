package com.vhry.dictionary;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static com.vhry.common.EndpointConstants.DICTIONARY_API;

@RestController
@RequestMapping(DICTIONARY_API)
@RequiredArgsConstructor
public class DictionaryController {

    private final DictionaryService service;


    @GetMapping
    public Map<String, Map<Long, String>> getAllDictionaries() {
        return service.getAllDictionaries();
    }

    @GetMapping("{dictionaryName}")
    public Map<Long, String> getAllDictionariesByName(@PathVariable String dictionaryName) {
        return service.getAllDictionariesByName(dictionaryName);
    }

    @GetMapping("{dictionaryName}/{id}")
    public Map<Long, String> getDictionaryById(@PathVariable Long id, @PathVariable String dictionaryName) {
        return service.getDictionaryById(dictionaryName, id);
    }

}
