package com.vhry.dictionary.universityRole;

import com.vhry.exception.AppException;
import com.vhry.util.Maps;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static com.vhry.exception.ErrorCodeEnum.E1004;

@Component
@RequiredArgsConstructor
public class UniversityRoleAdapter implements UniversityRolePort {

    private final UniversityJpaDictionaryRepository repository;

    private final UniversityDictionaryJpaMapper mapper;


    @Override
    public List<UniversityRole> findAll() {
        return mapper.fromJpaDictionaries(
                repository.findAll());
    }

    @Override
    public UniversityRole findById(Long id) {
        return mapper.fromJpaDictionary(Optional.of(
                repository.getById(id)).orElseThrow(
                () -> new AppException(E1004, Maps.<String, Object>builder()
                        .put("dictionaryId", id)
                        .build())));
    }

}
