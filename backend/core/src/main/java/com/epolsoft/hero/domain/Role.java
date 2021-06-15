package com.epolsoft.hero.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    private Long id;

    private String role;


    private static List<Role> roles;


    static {
        roles = new ArrayList<>();

        roles.add(new Role(0L, "Unknown"));
        roles.add(new Role(1L, "Specialist"));
        roles.add(new Role(2L, "Assassin"));
        roles.add(new Role(3L, "Warrior"));
        roles.add(new Role(4L, "Support"));
        roles.add(new Role(5L, "Multiclass"));
    }


    public static List<Role> values() {
        return roles;
    }


    public static Role getRoleById(Long id) {
        for (Role role : roles) {
            if(role.getId().equals(id)) {
                return role;
            }
        }

        return roles.get(0);
    }


    public static Long getIdByRole(String roleValue) {
        for (Role role : roles) {
            if(role.getRole().equals(roleValue)) {
                return role.getId();
            }
        }

        return 0L;
    }

}
