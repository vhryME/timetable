package com.epolsoft.dictionary;


import com.epolsoft.dictionary.dto.out.DictionaryDtoOut;
import com.epolsoft.dictionary.mapper.DictionaryDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/dictionary/")
@RequiredArgsConstructor
public class DictionaryController {

    private final DictionaryService service;
    private final DictionaryDtoMapper mapper;


    @GetMapping
    public DictionaryDtoOut getAllDictionaries() {
        return mapper.dictionaryToDictionaryDtoOut(service.getAllDictionaries());
    }

    @GetMapping("{dictionaryName}")
    public DictionaryDtoOut getAllDictionariesByName(@PathVariable String dictionaryName) {
        return mapper.dictionaryToDictionaryDtoOut(service.getAllDictionariesByName(dictionaryName));
    }


    @GetMapping("{dictionaryName}/{id}")
    public Object getDictionaryById(@PathVariable Integer id, @PathVariable String dictionaryName) {
        return service.getDictionaryById(dictionaryName, id);
    }

    @GetMapping("{dictionaryName}/{name}/{count}")
    public List<?> getAllDictionariesByName(@PathVariable String dictionaryName, @PathVariable String name,
                                         @PathVariable Long count) {
        return service.getDictionariesByName(dictionaryName, name, count);
    }

}