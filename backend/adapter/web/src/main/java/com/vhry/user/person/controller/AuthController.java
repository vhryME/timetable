package com.vhry.user.person.controller;

import com.vhry.user.common.domain.User;
import com.vhry.user.person.dto.out.PersonDtoOut;
import com.vhry.user.person.mapper.PersonDtoMapper;
import com.vhry.user.person.port.in.AuthUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.vhry.common.EndpointConstants.AUTH_API;
import static com.vhry.common.EndpointConstants.AUTH_ME_INFO;

@RestController
@RequestMapping(AUTH_API)
@RequiredArgsConstructor
public class AuthController {

    private final AuthUseCase authUseCase;

    private final PersonDtoMapper dtoMapper;


    @GetMapping(AUTH_ME_INFO)
    public PersonDtoOut me() {
        return dtoMapper.toOut(
                authUseCase.me( ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getEmail() ));
    }

}
