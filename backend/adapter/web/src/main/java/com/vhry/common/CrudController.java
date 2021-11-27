package com.vhry.common;

import com.vhry.domain.IdAccessor;
import com.vhry.mapper.DtoMapper;
import com.vhry.port.in.CrudUseCase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public interface CrudController<DtoIn extends DtoInAccessor, Entity extends IdAccessor, DtoOut extends DtoOutAccessor> {

    DtoMapper<DtoIn, Entity, DtoOut> getDtoMapper();

    CrudUseCase<Entity> getCrudUseCase();


    @PostMapping
    default DtoOut persist(@RequestBody @Valid final DtoIn entity) {
        return getDtoMapper().toOut(
                getCrudUseCase().persist(
                        getDtoMapper().fromIn(
                                entity)));
    }

    @PostMapping("/batch")
    default void persistAll(@RequestBody List<DtoIn> entities) {
        getCrudUseCase().persistAll(
                getDtoMapper().fromIn(
                        entities));
    }

    @GetMapping("/{id}")
    default DtoOut findById(@PathVariable Long id) {
        return getDtoMapper().toOut(
                getCrudUseCase().findById(id));
    }

    @DeleteMapping
    default void delete(Long id) {
        getCrudUseCase().delete(id);
    }

    @GetMapping
    default Page<DtoOut> findAll(Pageable page) {
        return getDtoMapper().toOut(
                getCrudUseCase().findAll(page));
    }

    @GetMapping("/all")
    default List<DtoOut> findAll() {
        return getDtoMapper().toOut(
                getCrudUseCase().findAll());
    }

}
