package com.vhry.file.controller;


import com.vhry.file.domain.File;
import com.vhry.file.dto.out.FileDtoOut;
import com.vhry.file.dto.out.FullFileDtoOut;
import com.vhry.file.mapper.FileDtoMapper;
import com.vhry.file.port.in.FileUseCase;
import com.vhry.mapper.UuidMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static com.vhry.common.EndpointConstants.FILE_API;
import static com.vhry.common.EndpointConstants.FILE_CONTENT;


@RestController
@RequestMapping(FILE_API)
@RequiredArgsConstructor
public class FileController {

    private final FileUseCase useCase;

    private final FileDtoMapper fileDtoMapper;

    private final UuidMapper uuidMapper;


    @GetMapping(value = "{uuid}")
    public FullFileDtoOut getFile(@PathVariable String uuid) {
        return fileDtoMapper.map(
                useCase.getFileByUUID(
                        uuidMapper.map(uuid)));
    }

    @GetMapping(FILE_CONTENT + "/{root}")
    public String readFileByRoot(@PathVariable String root) {
        return useCase.readFileByRoot(root);
    }

    @PostMapping
    public FileDtoOut saveFile(@RequestParam MultipartFile multipartFile) {
        return fileDtoMapper.toOut(
                useCase.storageFile(
                        fileDtoMapper.map(multipartFile)));
    }

    @PutMapping
    public FileDtoOut update(@RequestParam String uuid, @RequestParam MultipartFile multipartFile) {
        return fileDtoMapper.toOut(
                useCase.updateFile(
                        uuidMapper.map(uuid), fileDtoMapper.map(multipartFile)));
    }

    @GetMapping
    public List<FileDtoOut> getAllFiles() {
        return fileDtoMapper.toOut(useCase.getAllFiles());
    }

}