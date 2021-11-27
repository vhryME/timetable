package com.vhry.file.service;


import com.vhry.file.domain.File;
import com.vhry.file.port.in.FileUseCase;
import com.vhry.file.port.out.FilePort;
import com.vhry.file.port.out.FileStoragePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class FileService implements FileUseCase {

    private final FilePort port;

    private final FileStoragePort storagePort;


    @Override
    public String readFileByRoot(String root) {
        return port.readFileByRoot(root);
    }


    @Override
    public File getFileByUUID(UUID uuid) {
        File fileFromDB = storagePort.findFileByUUID(uuid);
        File file  = port.getFile(fileFromDB.getRoot());

        file.setDateOfCreation(fileFromDB.getDateOfCreation());
        file.setUuid(fileFromDB.getUuid());

        return file;
    }


    @Override
    public File storageFile(File file) {
        port.saveFile(file);

        return storagePort.storageFile(file);
    }

    @Override
    public File updateFile(UUID uuid, File file) {
        File forUpdateInStorage = port.updateFile(file);

        return storagePort.updateFile(uuid, forUpdateInStorage);
    }


    @Override
    public List<File> getAllFiles() {
        return storagePort.findAllFiles();
    }

}
