package com.vhry.web;


import io.swagger.annotations.ApiParam;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.Nullable;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.vhry.common.EndpointConstants.TIMETABLE_PROJECT_API;
import static springfox.documentation.builders.PathSelectors.regex;


@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).
                select().
                apis(RequestHandlerSelectors.basePackage("com.vhry")).
                paths(regex(TIMETABLE_PROJECT_API + "/.*")).
                build().
                directModelSubstitute(Pageable.class, SwaggerPageable.class);

    }


    @Data
    private static class SwaggerPageable {
        @ApiParam(value = "Results page you want to retrieve (0..N)")
        @Nullable
        private Integer page;

        @ApiParam(value = "Number of records per page")
        @Nullable
        private Integer size;

        @ApiParam(value = "Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported.")
        @Nullable
        private String sort;

    }

}