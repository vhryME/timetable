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
    private Long id;

    @NonNull
    private TypeOfMatch type;

    @NonNull
    private LocalDate date;

    @NonNull
    private Region region;

}