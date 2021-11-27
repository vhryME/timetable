package com.vhry.file.dto.out;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class FullFileDtoOut {

    @NotNull
    private String uuid;

    @NotNull
    private String root;

    @NotNull
    private byte[] content;

    @NotNull
    private String dateOfCreation;

}