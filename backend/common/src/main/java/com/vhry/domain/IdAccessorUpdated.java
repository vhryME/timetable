package com.vhry.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
public class IdAccessorUpdated extends IdAccessor {

    private String updatedBy;

    private LocalDate updatedAt;

}
