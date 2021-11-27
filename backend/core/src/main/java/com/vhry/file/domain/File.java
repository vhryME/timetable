package com.vhry.file.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class File {

    private UUID uuid;

    private String root;

    private byte[] content;

    private LocalDate dateOfCreation;

}