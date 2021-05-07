package com.epolsoft.dictionary;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/api/dictionary/")
@RequiredArgsConstructor
public class DictionaryController {

    private final DictionaryService service;


    @GetMapping
    public Map<String, Map<Integer, String>> getAllDictionaries() {
        return service.getAllDictionaries();
    }

    @GetMapping("{dictionaryName}")
    public Map<Integer, String> getAllDictionariesByName(@PathVariable String dictionaryName) {
        return service.getAllDictionariesByName(dictionaryName);
    }


    @GetMapping("{dictionaryName}/{id}")
    public Map<Integer, String> getDictionaryById(@PathVariable Integer id, @PathVariable String dictionaryName) {
        return service.getDictionaryById(dictionaryName, id);
    }

    @GetMapping("{dictionaryName}/{name}/{count}")
    public Map<Integer, String> getAllDictionariesByName(@PathVariable String dictionaryName, @PathVariable String name,
                                         @PathVariable Long count) {
        return service.getDictionariesByName(dictionaryName, name, count);
    }

}