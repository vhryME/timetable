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
    public Region getDictionaryById(Integer id) {
        return Region.getRegionById(id);
    }


    @Override
    public List<Region> getDictionariesByName(String name, Long count) {
        int counter = 0;
        List<Region> regions = new ArrayList<>();

        Iterator<Region> iterator = Arrays.asList(Region.values()).iterator();

        while(iterator.hasNext() && counter != count) {
            Region region = iterator.next();

            if(region.name().contains(name)) {
                counter++;
                regions.add(region);
            }
        }

        return regions;
    }

    @Override
    public String getNameOfDictionary() {
        return "region";
    }
}