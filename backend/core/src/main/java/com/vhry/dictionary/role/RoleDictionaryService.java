package com.vhry.dictionary.role;

import com.vhry.dictionary.DictionaryPort;
import com.vhry.dictionary.DictionaryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RoleDictionaryService implements DictionaryUseCase<Role> {

    private final RolePort port;

    @Override
    public DictionaryPort<Role> getDictionaryPort() {
        return port;
    }

    @Override
    public String getNameOfDictionary() {
        return "role";
    }

    public Set<String> getRoleNames() {
        return port.findAll()
                .stream()
                .map(Role::getRoleName)
                .collect(Collectors.toSet());
    }

}
