package com.vhry.user.common.domain;

import com.vhry.dictionary.role.Role;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigInteger;
import java.time.LocalDate;

@Data
public class User {

    private BigInteger id;

    private String username;

    private String email;

    private Role role;

    private String updatedBy;

    private LocalDate updatedAt;


}
