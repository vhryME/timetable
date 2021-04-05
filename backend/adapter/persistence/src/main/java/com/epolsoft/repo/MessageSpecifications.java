package com.epolsoft.repo;

import org.springframework.data.jpa.domain.Specification;

public class MessageSpecifications {

    public static Specification<MessageJpa> findByContent(String content) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("content"), content));
    }

}
