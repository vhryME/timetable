package com.vhry.file.mapper;


import com.vhry.file.domain.File;
import com.vhry.file.dto.out.FileDtoOut;
import com.vhry.file.dto.out.FullFileDtoOut;
import com.vhry.mapper.DateStringMapper;
import com.vhry.mapper.DtoMapper;
import com.vhry.mapper.UuidMapper;
import org.mapstruct.Mapper;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Mapper(uses = {DateStringMapper.class, UuidMapper.class})
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