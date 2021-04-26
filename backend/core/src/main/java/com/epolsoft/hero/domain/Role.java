package com.epolsoft.hero.domain;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
public enum Role {
    Specialist(1), Assassin(2), Warrior(3), Support(4), Multiclass(3), Unknown(0);


    public Integer id;

    public static Role getRoleById(Integer id) {
        for (Role role : Role.values()) {
            if(role.id.equals(id)) {
                return role;
            }
        }

        return null;
    }

    public static Integer getIdByRole(Role role) {
        for (Role roleTemp : Role.values()) {
            if(roleTemp.equals(role)) {
                return role.id;
            }
        }

        return 0;
    }
}
