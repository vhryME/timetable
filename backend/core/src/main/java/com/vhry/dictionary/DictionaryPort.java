package com.vhry.dictionary;

import java.util.List;

public interface DictionaryPort<Dict extends Dictionary> {

    List<Dict> findAll();

    Dict findById(Long id);

}
