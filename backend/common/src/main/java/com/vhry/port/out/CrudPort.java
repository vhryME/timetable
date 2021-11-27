package com.vhry.port.out;

import com.vhry.domain.IdAccessor;
import com.vhry.exception.AppException;
import com.vhry.mapper.JpaMapper;
import com.vhry.util.Maps;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.vhry.exception.ErrorCodeEnum.*;

public interface CrudPort<Entity extends IdAccessor, JpaEntity extends IdAccessor> {

    JpaRepository<JpaEntity, Long> getRepository();

    JpaMapper<Entity, JpaEntity> getJpaMapper();


    @Transactional
    default Entity persist(Entity jpaEntity) {
        return getJpaMapper().fromJpaEntity(
                getRepository().save(
                        Optional.ofNullable(getJpaMapper().toJpaEntity(jpaEntity)).orElseThrow(
                                () -> new AppException(E1001, Maps.<String, Object>builder()
                                        .put("entity", jpaEntity)
                                        .build())
                        )));
    }

    default Entity findById(Long id) {
        return getJpaMapper().fromJpaEntity(Optional.ofNullable(
                getRepository().getOne(id)).orElseThrow(
                        () -> new AppException(E1002, Maps.<String, Object>builder()
                                .put("entityId", id)
                                .build())
        ));
    }

    @Transactional
    default void delete(Long id) {
       if (getRepository().existsById(id)) {
            getRepository().deleteById(id);
        } else {
           throw new AppException(E1003, Maps.<String, Object>builder()
                   .put("entityId", id)
                   .build());
       }
    }

    default Page<Entity> findAll(Pageable page) {
        return getJpaMapper().fromJpaEntities(
                getRepository().findAll(page));
    }

    default List<Entity> findAll() {
        return getJpaMapper().fromJpaEntities(
                getRepository().findAll());
    }

}
