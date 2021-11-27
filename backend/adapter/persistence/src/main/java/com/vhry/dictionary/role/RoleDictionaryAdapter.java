package com.vhry.dictionary.role;

import com.vhry.exception.AppException;
import com.vhry.util.Maps;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static com.vhry.exception.ErrorCodeEnum.E1004;

@Component
@RequiredArgsConstructor
public class RoleDictionaryAdapter implements RolePort {

    private final RoleJpaDictionaryRepository dictionaryRepository;

    private final RoleDictionaryJpaMapper dictionaryJpaMapper;


    @Override
    public List<Role> findAll() {
        return dictionaryJpaMapper.fromJpaDictionaries(
                dictionaryRepository.findAll());
    }

    @Override
    public Role findById(Long id) {
        return dictionaryJpaMapper.fromJpaDictionary(Optional.of(
                dictionaryRepository.getById(id)).orElseThrow(
                () -> new AppException(E1004, Maps.<String, Object>builder()
                        .put("dictionaryId", id)
                        .build())));
    }

}
