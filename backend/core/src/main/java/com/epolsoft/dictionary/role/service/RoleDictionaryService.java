package com.epolsoft.dictionary.role.service;


import com.epolsoft.dictionary.DictionaryUseCase;
import com.epolsoft.hero.domain.Role;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class RoleDictionaryService implements DictionaryUseCase<Role> {

    @Override
    public Map<Long, String> getAllDictionaries() {
        java.util.Map<Long, String> dictionary = new HashMap<>();

        for (Role role : Role.values()) {
            dictionary.put(role.getId(), role.getRole());
        }

        return dictionary;
    }


    @Override
    public Map<Long, String> getDictionaryById(Long id) {
        Role role = Role.getRoleById(id);
        Map<Long, String> dictionary = new HashMap<>();

        if(role != null) {
            dictionary.put(role.getId(), role.getRole());
        }

        return dictionary;
    }


    @Override
    public Map<Long, String> getDictionariesByName(String name, Long count) {
        int counter = 0;
        Map<Long, String> dictionary = new HashMap<>();
        List<Role> roles = new ArrayList<>();

        Iterator<Role> iterator = Role.values().iterator();

        while(iterator.hasNext() && counter != count) {
            Role role = iterator.next();

            if(role.getRole().contains(name)) {
                counter++;
                roles.add(role);
            }
        }

        roles.forEach(role -> dictionary.put(role.getId(), role.getRole()));

        return dictionary;
    }


    @Override
    public String getNameOfDictionary() {
        return "role";
    }

}