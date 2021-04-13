package com.epolsoft.match.mapper;


import com.epolsoft.match.domain.Map;
import com.epolsoft.match.dto.in.MapDtoIn;
import com.epolsoft.match.dto.out.MapDtoOut;
import org.mapstruct.Mapper;
import org.mapstruct.ValueMapping;
import org.mapstruct.ValueMappings;


@Mapper
public interface MapDtoMapper {

    @ValueMappings({
            @ValueMapping(source = "AlteracPass", target = "AlteracPass"),
            @ValueMapping(source = "BattleFieldOfEternity", target = "BattleFieldOfEternity"),
            @ValueMapping(source = "BlackheartsBay", target = "BlackheartsBay"),
            @ValueMapping(source = "BraxisOutpost", target = "BraxisOutpost"),
            @ValueMapping(source = "CursedHollow", target = "CursedHollow"),
            @ValueMapping(source = "DragonShire", target = "DragonShire"),
            @ValueMapping(source = "GardenOfTerror", target = "GardenOfTerror"),
            @ValueMapping(source = "HanamuraTemple", target = "HanamuraTemple"),
            @ValueMapping(source = "HauntedMines", target = "HauntedMines"),
            @ValueMapping(source = "InfernalShines", target = "InfernalShines"),
            @ValueMapping(source = "LostCavern", target = "LostCavern"),
            @ValueMapping(source = "SilverCity", target = "SilverCity"),
            @ValueMapping(source = "SkyTemple", target = "SkyTemple"),
            @ValueMapping(source = "TombOfTheSpiderQueen", target = "TombOfTheSpiderQueen"),
            @ValueMapping(source = "TowersOfDoom", target = "TowersOfDoom"),
            @ValueMapping(source = "VolskayaFoundry", target = "VolskayaFoundry"),
            @ValueMapping(source = "WarheadJunction", target = "WarheadJunction"),
            @ValueMapping(source = "Unknown", target = "Unknown"),
    })
    Map mapDtoInToMap(MapDtoIn mapDtoIn);

    @ValueMappings({
            @ValueMapping(source = "AlteracPass", target = "AlteracPass"),
            @ValueMapping(source = "BattleFieldOfEternity", target = "BattleFieldOfEternity"),
            @ValueMapping(source = "BlackheartsBay", target = "BlackheartsBay"),
            @ValueMapping(source = "BraxisOutpost", target = "BraxisOutpost"),
            @ValueMapping(source = "CursedHollow", target = "CursedHollow"),
            @ValueMapping(source = "DragonShire", target = "DragonShire"),
            @ValueMapping(source = "GardenOfTerror", target = "GardenOfTerror"),
            @ValueMapping(source = "HanamuraTemple", target = "HanamuraTemple"),
            @ValueMapping(source = "HauntedMines", target = "HauntedMines"),
            @ValueMapping(source = "InfernalShines", target = "InfernalShines"),
            @ValueMapping(source = "LostCavern", target = "LostCavern"),
            @ValueMapping(source = "SilverCity", target = "SilverCity"),
            @ValueMapping(source = "SkyTemple", target = "SkyTemple"),
            @ValueMapping(source = "TombOfTheSpiderQueen", target = "TombOfTheSpiderQueen"),
            @ValueMapping(source = "TowersOfDoom", target = "TowersOfDoom"),
            @ValueMapping(source = "VolskayaFoundry", target = "VolskayaFoundry"),
            @ValueMapping(source = "WarheadJunction", target = "WarheadJunction"),
            @ValueMapping(source = "Unknown", target = "Unknown"),
    })
    MapDtoOut mapToMapDtoOut(Map map);

}
