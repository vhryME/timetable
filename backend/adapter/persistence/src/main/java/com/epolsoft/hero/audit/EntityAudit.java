package com.epolsoft.hero.audit;


import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;


@Data
@MappedSuperclass
public abstract class EntityAudit {

    @CreatedBy
    @Column(columnDefinition = "TEXT default current_user", updatable = false)
    protected String revisionBy;

    @LastModifiedDate
    @Column(name = "revision_date", columnDefinition = "TIMESTAMP default current_timestamp", updatable = false)
    protected LocalDate revisionDate;

    @Column(columnDefinition = "VARCHAR(6)")
    @Enumerated(EnumType.STRING)
    protected Action revisionAction;

}