package com.vhry.dictionary.role;

import com.vhry.dictionary.Dictionary;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Role extends Dictionary {

    private String roleName;

}
