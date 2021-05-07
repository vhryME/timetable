package com.epolsoft.dictionary.region.service;


import com.epolsoft.dictionary.DictionaryUseCase;
import com.epolsoft.match.domain.Region;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class RegionDictionaryService implements DictionaryUseCase<Region> {

    @Override
    public Map<Integer, String> getAllDictionaries() {
        java.util.Map<Integer, String> dictionary = new HashMap<>();

        for (Region region : Region.values()) {
            dictionary.put(region.id, region.name());
        }

        return dictionary;
    }

    @Override
    public Map<Integer, String> getDictionaryById(Integer id) {
        Region region = Region.getRegionById(id);
        Map<Integer, String> dictionary = new HashMap<>();

        if (region != null) {
            dictionary.put(region.id, region.name());
        }

        return dictionary;
    }


    @Override
    public Map<Integer, String> getDictionariesByName(String name, Long count) {
        int counter = 0;
        Map<Integer, String> dictionary = new HashMap<>();
        List<Region> regions = new ArrayList<>();

        Iterator<Region> iterator = Arrays.asList(Region.values()).iterator();

        while(iterator.hasNext() && counter != count) {
            Region region = iterator.next();

            if(region.name().contains(name)) {
                counter++;
                regions.add(region);
            }
        }

        regions.forEach(region -> dictionary.put(region.id, region.name()));

        return dictionary;
    }

    @Override
    public String getNameOfDictionary() {
        return "region";
    }
}