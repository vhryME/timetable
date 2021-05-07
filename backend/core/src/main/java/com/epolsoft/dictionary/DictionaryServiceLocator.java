package com.epolsoft.dictionary;


import com.epolsoft.dictionary.DictionaryUseCase;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;


@Getter
@Component
@RequiredArgsConstructor
public class DictionaryServiceLocator {

    private final Map<String, DictionaryUseCase<?>> dictionaryServices;


    public DictionaryUseCase<?> getDictionaryService(String serviceName) {
        return dictionaryServices.get(serviceName + "DictionaryService");
    }


    public void addDictionaryService(String dictionaryName, DictionaryUseCase<?> dictionaryUseCase) {
        dictionaryServices.put(dictionaryName, dictionaryUseCase);
    }
}
