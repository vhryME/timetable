package com.epolsoft.dictionary.type.service;


import com.epolsoft.dictionary.DictionaryUseCase;
import com.epolsoft.match.domain.TypeOfMatch;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class TypeOfMatchDictionaryService implements DictionaryUseCase<TypeOfMatch> {

    @Override
    public Map<Long, String> getAllDictionaries() {
        java.util.Map<Long, String> dictionary = new HashMap<>();

        for (TypeOfMatch typeOfMatch : TypeOfMatch.values()) {
            dictionary.put(typeOfMatch.getId(), typeOfMatch.getTypeOfMatch());
        }

        return dictionary;
    }


    @Override
    public Map<Long, String> getDictionaryById(Long id) {
        TypeOfMatch type = TypeOfMatch.getTypeOfMatchById(id);
        Map<Long, String> dictionary = new HashMap<>();

        if(type != null) {
            dictionary.put(type.getId(), type.getTypeOfMatch());
        }

        return dictionary;
    }


    @Override
    public Map<Long, String> getDictionariesByName(String name, Long count) {
        int counter = 0;
        Map<Long, String> dictionary = new HashMap<>();
        List<TypeOfMatch> types = new ArrayList<>();

        Iterator<TypeOfMatch> iterator = TypeOfMatch.values().iterator();

        while(iterator.hasNext() && counter != count) {
            TypeOfMatch type = iterator.next();

            if(type.getTypeOfMatch().contains(name)) {
                counter++;
                types.add(type);
            }
        }

        types.forEach(type -> dictionary.put(type.getId(), type.getTypeOfMatch()));

        return dictionary;
    }


    @Override
    public String getNameOfDictionary() {
        return "typeOfMatch";
    }

}