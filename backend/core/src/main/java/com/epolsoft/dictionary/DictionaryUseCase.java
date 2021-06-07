package com.epolsoft.dictionary;


import java.util.Map;


public interface DictionaryUseCase<T> {

    Map<Long, String> getAllDictionaries();


    Map<Long, String> getDictionaryById(Long id);


    Map<Long, String> getDictionariesByName(String name, Long count);


    String getNameOfDictionary();

}