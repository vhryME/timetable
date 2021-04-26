package com.epolsoft.dictionary.role.service;


import com.epolsoft.dictionary.DictionaryUseCase;
import com.epolsoft.hero.domain.Role;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class RoleDictionaryService implements DictionaryUseCase<Role> {

    @Override
    public Map<Integer, String> getAllDictionaries() {
        java.util.Map<Integer, String> dictionary = new HashMap<>();

        for (Role role : Role.values()) {
            dictionary.put(role.id, role.name());
        }

        return dictionary;
    }


    @Override
    public Role getDictionaryById(Integer id) {
        return Role.getRoleById(id);
    }


    @Override
    public List<Role> getDictionariesByName(String name, Long count) {
        int counter = 0;
        List<Role> roles = new ArrayList<>();

        Iterator<Role> iterator = Arrays.asList(Role.values()).iterator();

        while(iterator.hasNext() && counter != count) {
            Role role = iterator.next();

            if(role.name().contains(name)) {
                counter++;
                roles.add(role);
            }
        }

        return roles;
    }

    @Override
    public String getNameOfDictionary() {
        return "role";
    }

}