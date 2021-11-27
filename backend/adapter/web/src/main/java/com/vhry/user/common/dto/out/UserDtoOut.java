package com.vhry.user.common.dto.out;

import com.vhry.common.DtoOutAccessor;
import com.vhry.dictionary.DictionaryDtoOut;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserDtoOut extends DtoOutAccessor {

    private Long id;

    @NotBlank
    @Size(max = 128)
    private String username;

    @Email
    @NotBlank
    @Size(max = 128)
    private String email;

    @NotNull
    @Valid
    private DictionaryDtoOut role;

}
