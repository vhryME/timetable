package com.epolsoft.hero.audit;


import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;


@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class EntityAudit {

    @CreatedBy
    @Column(columnDefinition = "TEXT default current_user", updatable = false)
    protected String revisionBy;

    @LastModifiedDate
    @Column(name = "revision_date", columnDefinition = "TIMESTAMP default current_timestamp", updatable = false)
    protected LocalDate revisionDate;

    @Column(columnDefinition = "VARCHAR(6)")
    protected String revisionAction;

}