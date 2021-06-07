package com.epolsoft.file.mapper;


import com.epolsoft.file.domain.File;
import com.epolsoft.file.dto.out.FileDtoOut;
import com.epolsoft.file.dto.out.FullFileDtoOut;
import com.epolsoft.mapper.DateMapper;
import com.epolsoft.mapper.DtoMapper;
import com.epolsoft.mapper.UuidMapper;
import org.mapstruct.Mapper;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Mapper(uses = {DateMapper.class, UuidMapper.class})
public interface FileDtoMapper extends DtoMapper<FileDtoOut, File, FileDtoOut> {

    default File map(MultipartFile multipartFile) {
        File file = new File();

        file.setRoot(multipartFile.getOriginalFilename());
        try {
            file.setContent(multipartFile.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return file;
    }


    FullFileDtoOut map(File file);

}