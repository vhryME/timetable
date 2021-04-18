package com.epolsoft.match.validator;


import com.epolsoft.match.dto.in.PlayerInMatchDtoIn;
import com.epolsoft.match.dto.in.TeamDtoIn;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Component
@RequiredArgsConstructor
public class TeamDtoInValidator implements ConstraintValidator<TeamDtoInConstraint, TeamDtoIn> {

    @Override
    public void initialize(TeamDtoInConstraint constraint) {}


    @Override
    public boolean isValid(TeamDtoIn team, ConstraintValidatorContext context) {
        return team != null && team.getPlayers().size() == 5 && areLoginsUnique(team);
    }


    private boolean areLoginsUnique(TeamDtoIn teamDtoIn) {
        Set<String> loginSet;
        List<String> loginList = new ArrayList<>();

        for (PlayerInMatchDtoIn player : teamDtoIn.getPlayers()) {
            loginList.add(player.getPlayer().getLogin());
        }

        loginSet = new HashSet<>(loginList);

        return loginSet.size() == loginList.size();
    }

}