package com.vhry.dictionary.lessonType;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "lesson_types_dict")
public class LessonTypeJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Access(AccessType.PROPERTY)
    private Long id;

    @Column(name = "value")
    private String value;

}
