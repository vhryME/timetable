package com.vhry.dictionary.role;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum RoleEnum {

    ADMIN(1L, "Администратор", "ROLE_ADMIN"),
    USER(2L, "Пользователь", "ROLE_USER");

    public Long id;
    public String value;
    public String roleName;

}
