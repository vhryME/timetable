package com.vhry.common;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class DtoOutAccessor {

    @NotNull
    private Long id;

}
