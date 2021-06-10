package com.epolsoft.match.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Map {

    private Long id;

    private String map;


    private static final List<Map> maps;


    static {
        maps = new ArrayList<>();

        maps.add(new Map(0L, "Unknown"));
        maps.add(new Map(1L, "AlteracPass"));
        maps.add(new Map(2L, "BattleFieldOfEternity"));
        maps.add(new Map(3L, "BlackheartsBay"));
        maps.add(new Map(4L, "BraxisOutpost"));
        maps.add(new Map(5L, "CursedHollow"));
        maps.add(new Map(6L, "DragonShire"));
        maps.add(new Map(7L, "GardenOfTerror"));
        maps.add(new Map(8L, "HanamuraTemple"));
        maps.add(new Map(9L, "HauntedMines"));
        maps.add(new Map(10L, "InfernalShines"));
        maps.add(new Map(11L, "LostCavern"));
        maps.add(new Map(12L, "SilverCity"));
        maps.add(new Map(13L, "SkyTemple"));
        maps.add(new Map(14L, "TombOfTheSpiderQueen"));
        maps.add(new Map(15L, "VolskayaFoundry"));
        maps.add(new Map(16L, "WarheadJunction"));
        maps.add(new Map(17L, "WarheadJunction"));
    }


    public static List<Map> values() {
        return maps;
    }


    public static Map getMapById(Long id) {
        for (Map map : maps) {
            if(map.id.equals(id)) {
                return map;
            }
        }

        return null;
    }

    public static Long getIdByMap(Map map) {
        for (Map mapTemp : maps) {
            if(mapTemp.equals(map)) {
                return map.id;
            }
        }

        return 0L;
    }
}
