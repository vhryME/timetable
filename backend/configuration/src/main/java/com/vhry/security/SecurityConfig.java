package com.vhry.security;

//@Configuration
//@EnableWebSecurity
//@EnableOAuth2Sso
//@RequiredArgsConstructor
public class SecurityConfig /*extends WebSecurityConfigurerAdapter*/ {

//    private final UserCrudUseCase userCrudUseCase;
//
//    private final UserSearchUseCase userSearchUseCase;
//
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .mvcMatchers(EndpointConstants.TIMETABLE_PROJECT_API).permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .csrf().disable();
//    }
//
//    @Bean
//    public PrincipalExtractor principalExtractor() {
//        return map -> {
//            BigInteger id = new BigInteger(String.valueOf(map.get("sub")));
//
//            Role role = new Role();
//
//            role.setId(RoleEnum.USER.id);
//            role.setValue(RoleEnum.USER.value);
//            role.setValue(RoleEnum.USER.roleName);
//
//            return Optional
//                    .of(userSearchUseCase.findUserByEmail((String) map.get("email")))
//                    .orElseGet(() ->
//                            userCrudUseCase.persist(new User()
//                                    .setId(id)
//                                    .setEmail((String) map.get("email"))
//                                    .setRole(role)
//                                    .setUsername((String) map.get("email"))));
//        };
//    }

}
