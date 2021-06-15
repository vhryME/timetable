package com.epolsoft.hero.domain;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
public enum Status {
    DRAFT(0L), ACTIVE(1L), DELETE(2L);

    private Long id;

    public static Status getStatusById(Long id) {
        for (Status status : values()) {
            if(status.id.equals(id)) {
                return status;
            }
        }

        return null;
    }


    public static Long getIdByStatus(Status status) {
        for (Status statusTemp : values()) {
            if(statusTemp.equals(status)) {
                return status.id;
            }
        }

        return 0L;
    }

}
