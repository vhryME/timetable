package com.vhry.dictionary.lessonType;

import com.vhry.dictionary.DictionaryPort;
import com.vhry.dictionary.DictionaryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LessonTypeDictionaryService implements DictionaryUseCase<LessonType> {

    private final LessonTypePort port;

    @Override
    public DictionaryPort<LessonType> getDictionaryPort() {
        return port;
    }

    @Override
    public String getNameOfDictionary() {
        return "lessonType";
    }

}
