package com.vhry.dictionary.universityRole;

import com.vhry.dictionary.DictionaryPort;
import com.vhry.dictionary.DictionaryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UniversityRoleDictionaryService implements DictionaryUseCase<UniversityRole> {

    private final UniversityRolePort port;

    @Override
    public DictionaryPort<UniversityRole> getDictionaryPort() {
        return port;
    }

    @Override
    public String getNameOfDictionary() {
        return "universityRole";
    }

}
