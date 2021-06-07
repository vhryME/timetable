package com.epolsoft.dictionary.region.service;


import com.epolsoft.dictionary.DictionaryUseCase;
import com.epolsoft.match.domain.Region;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class RegionDictionaryService implements DictionaryUseCase<Region> {

    @Override
    public Map<Long, String> getAllDictionaries() {
        java.util.Map<Long, String> dictionary = new HashMap<>();

        for (Region region : Region.values()) {
            dictionary.put(region.getId(), region.getRegion());
        }

        return dictionary;
    }

    @Override
    public Map<Long, String> getDictionaryById(Long id) {
        Region region = Region.getRegionById(id);
        Map<Long, String> dictionary = new HashMap<>();

        if (region != null) {
            dictionary.put(region.getId(), region.getRegion());
        }

        return dictionary;
    }


    @Override
    public Map<Long, String> getDictionariesByName(String name, Long count) {
        int counter = 0;
        Map<Long, String> dictionary = new HashMap<>();
        List<Region> regions = new ArrayList<>();

        Iterator<Region> iterator = Region.values().iterator();

        while(iterator.hasNext() && counter != count) {
            Region region = iterator.next();

            if(region.getRegion().contains(name)) {
                counter++;
                regions.add(region);
            }
        }

        regions.forEach(region -> dictionary.put(region.getId(), region.getRegion()));

        return dictionary;
    }


    @Override
    public String getNameOfDictionary() {
        return "region";
    }
}