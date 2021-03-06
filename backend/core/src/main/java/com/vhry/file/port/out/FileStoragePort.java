package com.vhry.file.port.out;


import com.vhry.file.domain.File;

import java.util.List;
import java.util.UUID;


public interface FileStoragePort {

    File findFileByUUID(UUID uuid);


    void deleteFile(UUID uuid);


    File storageFile (File file);


    File updateFile (UUID uuid, File file);


    List<File> findAllFiles();

}