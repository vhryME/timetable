package com.epolsoft.match.dto.out;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDtoOut {

    @NotNull
    private Long id;

    @NotNull
    private String login;

}
