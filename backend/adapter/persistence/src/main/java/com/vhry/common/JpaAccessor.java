package com.vhry.common;

import javax.persistence.Column;
import javax.validation.constraints.Size;
import java.util.Date;


public class JpaAccessor {

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "updated_by")
    private String updatedBy;

}
