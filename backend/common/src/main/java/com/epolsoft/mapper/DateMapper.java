package com.epolsoft.mapper;


import org.mapstruct.Mapper;

import java.time.LocalDate;


@Mapper
public interface DateMapper {

    default LocalDate map(String date) { return date != null ? LocalDate.parse(date) : null; }


    default String map(LocalDate date) {
        return date != null ? date.toString() : null;
    }

}