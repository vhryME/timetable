package com.epolsoft.dictionary.map.service;


import com.epolsoft.dictionary.DictionaryUseCase;
import com.epolsoft.match.domain.Map;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class MapDictionaryService implements DictionaryUseCase<Map> {

    @Override
    public java.util.Map<Integer, String> getAllDictionaries() {

        java.util.Map<Integer, String> dictionary = new HashMap<>();

        for (Map map : Map.values()) {
            dictionary.put(map.id, map.name());
        }

        return dictionary;
    }


    @Override
    public Map getDictionaryById(Integer id) {
        return Map.getMapById(id);
    }


    @Override
    public List<Map> getDictionariesByName(String name, Long count) {
        int counter = 0;
        List<Map> maps = new ArrayList<>();

        Iterator<Map> iterator = Arrays.asList(Map.values()).iterator();

        while(iterator.hasNext() && counter != count) {
            Map map = iterator.next();

            if(map.name().contains(name)) {
                counter++;
                maps.add(map);
            }
        }

        return maps;
    }

    @Override
    public String getNameOfDictionary() {
        return "map";
    }
}