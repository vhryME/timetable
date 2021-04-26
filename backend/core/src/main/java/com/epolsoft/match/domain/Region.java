package com.epolsoft.match.domain;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
public enum Region {
    NA(1), EU(2), KR(3), CN(4), Unknown(0);


    public Integer id;

    public static Region getRegionById(Integer id) {
        for (Region region : Region.values()) {
            if(region.id.equals(id)) {
                return region;
            }
        }

        return null;
    }

    public static Integer getIdByRegion(Region region) {
        for (Region roleTemp : Region.values()) {
            if(roleTemp.equals(region)) {
                return region.id;
            }
        }

        return 0;
    }
}
