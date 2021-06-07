package com.epolsoft.file.port.in;


import com.epolsoft.file.domain.File;

import java.util.List;
import java.util.UUID;


public interface FileUseCase {

    String readFileByRoot(String root);


    File getFileByUUID(UUID uuid);


    File storageFile(File file);


    File updateFile(UUID uuid, File file);


    List<File> getAllFiles();

}