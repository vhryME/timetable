package com.vhry.file.mapper;


import com.vhry.file.domain.File;
import com.vhry.file.domain.FileJpa;
import com.vhry.mapper.DateStringMapper;
import com.vhry.mapper.JpaMapper;
import org.mapstruct.Mapper;


@Mapper(uses = {DateStringMapper.class})
public interface FileJpaMapper extends JpaMapper<FileJpa, File> {

}