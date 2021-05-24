package com.epolsoft.hero.audit;


import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;


public interface AuditListener {

    @PrePersist
    @Transactional
    void prePersist(Object auditEntity);

    @PreUpdate
    @Transactional
    void preUpdate(Object auditEntity);

    @PreRemove
    @Transactional
    void preRemove(Object auditEntity);

}