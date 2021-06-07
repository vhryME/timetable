package com.epolsoft.file.mapper;


import com.epolsoft.file.domain.File;
import com.epolsoft.file.domain.FileJpa;
import com.epolsoft.mapper.DateMapper;
import com.epolsoft.mapper.JpaMapper;
import org.mapstruct.Mapper;


@Mapper(uses = {DateMapper.class})
public interface FileJpaMapper extends JpaMapper<FileJpa, File> {}