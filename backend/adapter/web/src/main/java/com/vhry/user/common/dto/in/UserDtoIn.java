package com.vhry.user.common.dto.in;

import com.vhry.common.DtoInAccessor;
import com.vhry.dictionary.DictionaryDtoIn;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserDtoIn extends DtoInAccessor {

    @NotBlank
    @Size(max = 128)
    private String username;

    @Email
    @NotBlank
    @Size(max = 128)
    private String email;

    @NotNull
    @Valid
    private DictionaryDtoIn role;

}
