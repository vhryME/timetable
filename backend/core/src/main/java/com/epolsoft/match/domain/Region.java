package com.epolsoft.match.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Region {

    private Long id;

    private String Region;


    private static final List<Region> regions;


    static {
        regions = new ArrayList<>();

        regions.add(new Region(0L, "Unknown"));
        regions.add(new Region(1L, "EU"));
        regions.add(new Region(2L, "KR"));
        regions.add(new Region(3L, "CN"));
        regions.add(new Region(4L, "NA"));
    }


    public static List<Region> values() {
        return regions;
    }


    public static Region getRegionById(Long id) {
        for (Region region : regions) {
            if(region.id.equals(id)) {
                return region;
            }
        }

        return null;
    }

    public static Long getIdByRegion(Region region) {
        for (Region roleTemp : regions) {
            if(roleTemp.equals(region)) {
                return region.id;
            }
        }

        return 0L;
    }

}