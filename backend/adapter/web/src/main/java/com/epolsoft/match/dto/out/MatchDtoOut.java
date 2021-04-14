package com.epolsoft.match.dto.out;


import com.epolsoft.match.domain.Region;
import com.epolsoft.match.domain.TypeOfMatch;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatchDtoOut {

    @NonNull
    private Integer id;

    @NonNull
    private String type;

    @NonNull
    private String date;

    @NonNull
    private String region;

}