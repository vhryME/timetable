package com.vhry.file.adapter;


import com.vhry.file.domain.File;
import com.vhry.file.domain.FileJpa;
import com.vhry.file.mapper.FileJpaMapper;
import com.vhry.file.port.out.FileStoragePort;
import com.vhry.file.repo.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


@Component
@RequiredArgsConstructor
public class FileStorageAdapter implements FileStoragePort {

    private final FileJpaMapper fileJpaMapper;

    private final FileRepository repository;


    @Override
    @Transactional
    public File findFileByUUID(UUID uuid) {
        return fileJpaMapper.toJpaEntity(repository.findByUuid(uuid));
    }


    @Override
    @Transactional
    public void deleteFile(UUID uuid) {
        repository.deleteById(uuid);
    }


    @Override
    @Transactional
    public File storageFile(File file) {
        FileJpa fileJpa = fileJpaMapper.fromJpaEntity(file);

        fileJpa.setDateOfCreation(LocalDate.now());

        return fileJpaMapper.toJpaEntity(repository.save(fileJpa));
    }


    @Override
    @Transactional
    public File updateFile(UUID uuid, File file) {
        if(repository.existsById(uuid)) {
            FileJpa fileJpaFromDB = repository.findByUuid(uuid);

            FileJpa fileJpa = fileJpaMapper.fromJpaEntity(file);

            fileJpa.setUuid(fileJpaFromDB.getUuid());
            fileJpa.setDateOfCreation(fileJpaFromDB.getDateOfCreation());

            return fileJpaMapper.toJpaEntity(repository.save(fileJpa));
        }

        return null;
    }


    @Override
    @Transactional
    public List<File> findAllFiles() {
        return fileJpaMapper.toJpaEntities(repository.findAll());
    }

}