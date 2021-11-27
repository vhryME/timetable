package com.vhry.mapper;


import org.mapstruct.Mapper;

import java.util.UUID;


@Mapper
public interface UuidMapper {

    default String map(UUID uuid) {
        return uuid.toString();
    }


    default UUID map(String uuid) {
        return UUID.fromString(uuid);
    }

}