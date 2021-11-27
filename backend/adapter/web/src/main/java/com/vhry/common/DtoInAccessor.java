package com.vhry.common;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class DtoInAccessor {

    @Min(1)
    private Long id;

}
