package com.vhry.port.in;

import com.vhry.domain.IdAccessor;
import com.vhry.port.out.CrudPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigInteger;
import java.util.Collection;
import java.util.List;

public interface CrudUseCase<Entity extends IdAccessor> {

    CrudPort<Entity, ?> getCrudPort();


    default Entity persist(Entity entity) {
        return getCrudPort().persist(entity);
    }

    default void persistAll(List<Entity> entities) {
        entities.forEach(entity -> getCrudPort().persist(entity));
    }

    default Entity findById(Long id) {
        return getCrudPort().findById(id);
    }

    default void delete(Long id) {
        getCrudPort().delete(id);
    }

    default Page<Entity> findAll(Pageable page) {
        return getCrudPort().findAll(page);
    }

    default List<Entity> findAll() {
        return getCrudPort().findAll();
    }

}
