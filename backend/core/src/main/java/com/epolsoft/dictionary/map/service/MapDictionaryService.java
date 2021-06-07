package com.epolsoft.dictionary.map.service;


import com.epolsoft.dictionary.DictionaryUseCase;
import com.epolsoft.match.domain.Map;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class MapDictionaryService implements DictionaryUseCase<Map> {

    @Override
    public java.util.Map<Long, String> getAllDictionaries() {

        java.util.Map<Long, String> dictionary = new HashMap<>();

        for (Map map : Map.values()) {
            dictionary.put(map.getId(), map.getMap());
        }

        return dictionary;
    }


    @Override
    public java.util.Map<Long, String> getDictionaryById(Long id) {
        Map map = Map.getMapById(id);
        java.util.Map<Long, String> dictionary = new HashMap<>();

        if (map != null) {
            dictionary.put(map.getId(), map.getMap());
        }

        return dictionary;
    }


    @Override
    public java.util.Map<Long, String> getDictionariesByName(String name, Long count) {
        int counter = 0;
        java.util.Map<Long, String> dictionary = new HashMap<>();
        List<Map> maps = new ArrayList<>();

        Iterator<Map> iterator = Map.values().iterator();

        while(iterator.hasNext() && counter != count) {
            Map map = iterator.next();

            if(map.getMap().contains(name)) {
                counter++;
                maps.add(map);
            }
        }

        maps.forEach(map -> dictionary.put(map.getId(), map.getMap()));

        return dictionary;
    }

    @Override
    public String getNameOfDictionary() {
        return "map";
    }
}