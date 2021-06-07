package com.epolsoft.file.adapter;


import com.epolsoft.file.domain.File;
import com.epolsoft.file.port.out.FilePort;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;


@Component
public class FileAdapter implements FilePort {

    @Value("${com.epolsoft.file.path}")
    private String path;


    @Override
    public String readFileByRoot(String root) {
        try {
            if(Files.isExecutable(Paths.get(root))) {
                return Files.readString(Paths.get(root));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public File saveFile(File file) {
        try {
            Files.write(Paths.get((path + "/" + file.getRoot())), file.getContent());
        } catch (IOException e) { e.printStackTrace(); }

        file.setRoot(path + file.getRoot());

        return file;
    }


    @Override
    public File updateFile(com.epolsoft.file.domain.File file) {
        FileWriter fileWriter;

        try {
            fileWriter = new FileWriter(path + "/" + file.getRoot());
            fileWriter.write(Arrays.toString(file.getContent()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        file.setRoot(path + file.getRoot());

        return file;
    }


    @Override
    public File getFile(String path) {
        File file = new File();

        file.setRoot(path);

        try {
            file.setContent(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return file;
    }

}