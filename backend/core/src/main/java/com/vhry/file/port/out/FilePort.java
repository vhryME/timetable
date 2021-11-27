package com.vhry.file.port.out;


import com.vhry.file.domain.File;


public interface FilePort {

    String readFileByRoot(String root);


    File saveFile(File file);


    File updateFile(File file);


    File getFile(String path);

}