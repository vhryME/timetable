package com.epolsoft.dictionary;


import java.util.Map;


public interface DictionaryUseCase<T> {

    Map<Integer, String> getAllDictionaries();


    Map<Integer, String> getDictionaryById(Integer id);


    Map<Integer, String> getDictionariesByName(String name, Long count);


    String getNameOfDictionary();

}