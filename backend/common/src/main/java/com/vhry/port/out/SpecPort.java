package com.vhry.port.out;

import com.vhry.domain.IdAccessor;
import com.vhry.exception.AppException;
import com.vhry.mapper.JpaMapper;
import com.vhry.util.Maps;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

import static com.vhry.exception.ErrorCodeEnum.E1005;

public interface SpecPort<Entity, JpaEntity> {

    JpaSpecificationExecutor<JpaEntity> getJpaSpecificationExecutor();

    JpaMapper<Entity, JpaEntity> getJpaMapper();


    default List<Entity> findBySpec(Specification<JpaEntity> specification) {
        return findBySpec(specification, getJpaMapper());
    }

    default List<Entity> findBySpec(Specification<JpaEntity> specification, Sort sort) {
        return findBySpec(specification, sort, getJpaMapper());
    }

    default Page<Entity> findBySpec(Specification<JpaEntity> specification, Pageable pageable, JpaMapper<Entity, JpaEntity> jpaMapper) {
        return jpaMapper.fromJpaEntities(
                getJpaSpecificationExecutor().findAll(specification, pageable));
    }

    default List<Entity> findBySpec(Specification<JpaEntity> specification, Sort sort, JpaMapper<Entity, JpaEntity> jpaMapper) {
        return jpaMapper.fromJpaEntities(
                getJpaSpecificationExecutor().findAll(specification, sort));
    }

    default List<Entity> findBySpec(Specification<JpaEntity> specification, JpaMapper<Entity, JpaEntity> jpaMapper) {
        return jpaMapper.fromJpaEntities(
                getJpaSpecificationExecutor().findAll(specification));
    }

    default Page<Entity> findBySpec(Specification<JpaEntity> specification, Pageable pageable) {
        return findBySpec(specification, pageable, getJpaMapper());
    }

    default Entity findOneBySpec(Specification<JpaEntity> specification) {
        return findOneBySpec(specification, getJpaMapper());
    }

    default Entity findOneBySpec(Specification<JpaEntity> specification, JpaMapper<Entity, JpaEntity> jpaMapper) {
        return jpaMapper.fromJpaEntity(
                getJpaSpecificationExecutor().findOne(specification).orElse(null));
    }

    default long count(Specification<JpaEntity> specification) {
        return getJpaSpecificationExecutor().count(specification);
    }

}
