package com.epolsoft.file.controller;


import com.epolsoft.file.domain.File;
import com.epolsoft.file.dto.out.FileDtoOut;
import com.epolsoft.file.dto.out.FullFileDtoOut;
import com.epolsoft.file.mapper.FileDtoMapper;
import com.epolsoft.file.port.in.FileUseCase;
import com.epolsoft.mapper.UuidMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@RequestMapping("/api/file")
@RequiredArgsConstructor
public class FileController {

    private final FileUseCase useCase;

    private final FileDtoMapper fileDtoMapper;

    private final UuidMapper uuidMapper;


    @GetMapping(value = "{uuid}")
    public FullFileDtoOut getFile(@PathVariable String uuid) {
        return fileDtoMapper.map(useCase.getFileByUUID(uuidMapper.map(uuid)));
    }


    @GetMapping("content/{root}")
    public String readFileByRoot(@PathVariable String root) {
        return useCase.readFileByRoot(root);
    }


    @PostMapping
    public FileDtoOut saveFile(@RequestParam MultipartFile multipartFile) {
        File file = fileDtoMapper.map(multipartFile);

        return fileDtoMapper.entityToOut(useCase.storageFile(file));
    }


    @PutMapping
    public FileDtoOut update(@RequestParam String uuid, @RequestParam MultipartFile multipartFile) {
        File file = fileDtoMapper.map(multipartFile);

        return fileDtoMapper.entityToOut(useCase.updateFile(uuidMapper.map(uuid), file));
    }


    @GetMapping
    public List<FileDtoOut> getAllFiles() {
        return fileDtoMapper.entitiesToOutList(useCase.getAllFiles());
    }

}