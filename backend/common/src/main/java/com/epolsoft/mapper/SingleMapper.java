package com.epolsoft.mapper;


import java.util.List;
import java.util.stream.Collectors;


public interface SingleMapper<IN, OUT> {

    OUT inToOut (IN in);


    IN outToIn (OUT out);


    default List<IN> listOutToListIn(List<OUT> list) {
        return list.stream().map(this::outToIn).collect(Collectors.toList());
    }


    default List<OUT> listInToListOut(List<IN> list) {
        return list.stream().map(this::inToOut).collect(Collectors.toList());
    }

}