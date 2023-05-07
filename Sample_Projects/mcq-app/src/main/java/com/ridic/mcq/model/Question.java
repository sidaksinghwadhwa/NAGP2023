package com.ridic.mcq.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Question {

    @Getter
    @Id
    @GeneratedValue
    private Integer qid;

    @Getter
    @Setter
    @Column
    private String domain;

    @Getter
    @Setter
    @Column
    private String text;

    @Getter
    @Setter
    @Column
    private Boolean hasMultipleAnswers;

    @Getter
    @Setter
    @Column
    private Boolean hasImage;

    @Getter
    @Setter
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "question")
    private Set<Option> options;

}
