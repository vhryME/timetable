package com.epolsoft.match.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypeOfMatch {

    private Long id;

    private String typeOfMatch;


    private static final List<TypeOfMatch> types;

    static {
        types = new ArrayList<>();

        types.add(new TypeOfMatch(0L,"Unknown"));
        types.add(new TypeOfMatch(1L,"QuickMatch"));
        types.add(new TypeOfMatch(2L, "UnrankedDraft"));
        types.add(new TypeOfMatch(3L, "HeroLeague"));
        types.add(new TypeOfMatch(4L, "TeamLeague"));
        types.add(new TypeOfMatch(5L, "Brawl"));
    }


    public static List<TypeOfMatch> values() {
        return types;
    }


    public static TypeOfMatch getTypeOfMatchById(Long id) {
        for (TypeOfMatch type : types) {
            if(type.id.equals(id)) {
                return type;
            }
        }

        return null;
    }

    public static Long getIdByTypeOfMatch(TypeOfMatch typeOfMatch) {
        for (TypeOfMatch typeOfMatchTemp : types) {
            if(typeOfMatchTemp.equals(typeOfMatch)) {
                return typeOfMatchTemp.id;
            }
        }

        return 0L;
    }

}