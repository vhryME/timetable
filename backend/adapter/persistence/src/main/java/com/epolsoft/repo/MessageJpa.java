package com.epolsoft.repo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "message")
public class MessageJpa {

    @Id
    @GeneratedValue
    private Long id;

    private String content;

}
