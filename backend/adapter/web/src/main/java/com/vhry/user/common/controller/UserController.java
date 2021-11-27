package com.vhry.user.common.controller;

import com.vhry.common.CrudController;
import com.vhry.user.common.domain.User;
import com.vhry.mapper.DtoMapper;
import com.vhry.port.in.CrudUseCase;
import com.vhry.user.common.dto.in.UserDtoIn;
import com.vhry.user.common.dto.out.UserDtoOut;
import com.vhry.user.common.mapper.UserDtoMapper;
import com.vhry.user.common.port.in.UserCrudUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigInteger;
import java.util.List;

import static com.vhry.common.EndpointConstants.USER_API;

@RestController
@RequestMapping(USER_API)
@RequiredArgsConstructor
public class UserController {

    private final UserDtoMapper dtoMapper;

    private final UserCrudUseCase crudUseCase;


    @PostMapping
    public UserDtoOut persist(@RequestBody @Valid final UserDtoIn entity) {
        return dtoMapper.toOut(
                crudUseCase.persist(
                        dtoMapper.fromIn(
                                entity)));
    }

    @PostMapping("/batch")
    public void persistAll(@RequestBody List<UserDtoIn> entities) {
        crudUseCase.persistAll(
                dtoMapper.fromIn(
                        entities));
    }

    @GetMapping("/{id}")
    public UserDtoOut findById(@PathVariable BigInteger id) {
        return dtoMapper.toOut(
                crudUseCase.findById(id));
    }

    @DeleteMapping
    public void delete(BigInteger id) {
        crudUseCase.delete(id);
    }

    @GetMapping
    public Page<UserDtoOut> findAll(Pageable page) {
        return dtoMapper.toOut(
                crudUseCase.findAll(page));
    }

    @GetMapping("/all")
    public List<UserDtoOut> findAll() {
        return dtoMapper.toOut(
                crudUseCase.findAll());
    }

}
