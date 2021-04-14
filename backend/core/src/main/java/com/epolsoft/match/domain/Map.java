package com.epolsoft.match.domain;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
public enum Map {
    AlteracPass, BattleFieldOfEternity, BlackheartsBay, BraxisOutpost, CursedHollow, DragonShire, GardenOfTerror,
    HanamuraTemple, HauntedMines, InfernalShines, LostCavern, SilverCity, SkyTemple, TombOfTheSpiderQueen,
    TowersOfDoom, VolskayaFoundry, WarheadJunction, Unknown;


    public Integer id;

    public static Map getMapById(Integer id) {
        for (Map map : Map.values()) {
            if(map.id.equals(id)) {
                return map;
            }
        }

        return null;
    }

    public static Integer getIdByMap(Map map) {
        for (Map mapTemp : Map.values()) {
            if(mapTemp.equals(map)) {
                return map.id;
            }
        }

        return 0;
    }
}
