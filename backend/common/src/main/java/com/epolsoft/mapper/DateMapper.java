package com.epolsoft.mapper;


import org.mapstruct.Mapper;

import java.time.LocalDate;


@Mapper
public interface DateMapper extends SingleMapper<String, LocalDate> {

    @Override
    default LocalDate inToOut(String date) { return date != null ? LocalDate.parse(date) : null; }

    @Override
    default String outToIn(LocalDate date) {
        return date != null ? date.toString() : null;
    }

}