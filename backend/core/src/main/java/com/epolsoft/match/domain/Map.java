package com.epolsoft.match.domain;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Arrays;


@NoArgsConstructor
@AllArgsConstructor
public enum Map {
    AlteracPass, BattleFieldOfEternity, BlackheartsBay, BraxisOutpost, CursedHollow, DragonShire, GardenOfTerror,
    HanamuraTemple, HauntedMines, InfernalShines, LostCavern, SilverCity, SkyTemple, TombOfTheSpiderQueen,
    TowersOfDoom, VolskayaFoundry, WarheadJunction, Unknown;

    public Integer id;

    public static Map getMapById(Integer stateId) {
        return Arrays.stream(Map.values())
                .filter(map -> map.id.equals(stateId))
                .findFirst()
                .orElse(null);
    }
}
