package com.epolsoft.match.domain;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
public enum TypeOfMatch {
    QuickMatch(1), UnrankedDraft(2), HeroLeague(3), TeamLeague(4), Brawl(5), Unknown(0);


    public Integer id;

    public static TypeOfMatch getTypeOfMatchById(Integer id) {
        for (TypeOfMatch type : TypeOfMatch.values()) {
            if(type.id.equals(id)) {
                return type;
            }
        }

        return null;
    }

    public static Integer getIdByTypeOfMatch(TypeOfMatch typeOfMatch) {
        for (TypeOfMatch typeOfMatchTemp : TypeOfMatch.values()) {
            if(typeOfMatchTemp.equals(typeOfMatch)) {
                return typeOfMatchTemp.id;
            }
        }

        return 0;
    }

}