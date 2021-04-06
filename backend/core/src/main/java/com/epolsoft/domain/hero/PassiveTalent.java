package com.epolsoft.domain.hero;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassiveTalent extends Talent {

    private Long id;

    private String skill;

}
