package com.epolsoft.dictionary.type.service;


import com.epolsoft.dictionary.DictionaryUseCase;
import com.epolsoft.match.domain.TypeOfMatch;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class TypeOfMatchDictionaryService implements DictionaryUseCase<TypeOfMatch> {

    @Override
    public Map<Integer, String> getAllDictionaries() {
        java.util.Map<Integer, String> dictionary = new HashMap<>();

        for (TypeOfMatch typeOfMatch : TypeOfMatch.values()) {
            dictionary.put(typeOfMatch.id, typeOfMatch.name());
        }

        return dictionary;
    }


    @Override
    public TypeOfMatch getDictionaryById(Integer id) {
        return TypeOfMatch.getTypeOfMatchById(id);
    }


    @Override
    public List<TypeOfMatch> getDictionariesByName(String name, Long count) {
        int counter = 0;
        List<TypeOfMatch> types = new ArrayList<>();

        Iterator<TypeOfMatch> iterator = Arrays.asList(TypeOfMatch.values()).iterator();

        while(iterator.hasNext() && counter != count) {
            TypeOfMatch type = iterator.next();

            if(type.name().contains(name)) {
                counter++;
                types.add(type);
            }
        }

        return types;
    }

    @Override
    public String getNameOfDictionary() {
        return "typeOfMatch";
    }

}