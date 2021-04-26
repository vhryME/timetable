package com.epolsoft.dictionary;


import java.util.List;
import java.util.Map;


public interface DictionaryUseCase<T> {

    Map<Integer, String> getAllDictionaries();


    T getDictionaryById(Integer id);


    List<T> getDictionariesByName(String name, Long count);


    String getNameOfDictionary();

}