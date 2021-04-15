package com.epolsoft.match.domain;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
public enum Map {

    AlteracPass(1), BattleFieldOfEternity(2), BlackheartsBay(3), BraxisOutpost(4), CursedHollow(5),
    DragonShire(6), GardenOfTerror(7), HanamuraTemple(8), HauntedMines(9), InfernalShines(10),
    LostCavern(11), SilverCity(12), SkyTemple(13), TombOfTheSpiderQueen(14), TowersOfDoom(15),
    VolskayaFoundry(15), WarheadJunction(16), Unknown(0);


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
