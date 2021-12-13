package com.vhry.security;

import com.vhry.common.EndpointConstants;
import com.vhry.dictionary.role.Role;
import com.vhry.dictionary.role.RoleEnum;
import com.vhry.user.common.domain.User;
import com.vhry.user.common.port.in.UserCrudUseCase;
import com.vhry.user.common.port.in.UserSearchUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;

import java.math.BigInteger;
import java.util.Optional;

@Configuration
@EnableWebSecurity
@EnableOAuth2Sso
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserCrudUseCase userCrudUseCase;

    private final UserSearchUseCase userSearchUseCase;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .mvcMatchers(EndpointConstants.TIMETABLE_PROJECT_API).permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf().disable();
    }

    @Bean
    public PrincipalExtractor principalExtractor() {
        return map -> {
            BigInteger id = new BigInteger(String.valueOf(map.get("sub")));

            Role role = new Role();

            role.setId(RoleEnum.USER.id);
            role.setValue(RoleEnum.USER.value);
            role.setValue(RoleEnum.USER.roleName);

            return Optional
                    .ofNullable(userSearchUseCase.findUserByEmail((String) map.get("email")))
                    .orElseGet(() ->
                            userCrudUseCase.persist(new User()
                                    .setId(id)
                                    .setEmail((String) map.get("email"))
                                    .setRole(role)
                                    .setUsername((String) map.get("email"))));
        };
    }

}
