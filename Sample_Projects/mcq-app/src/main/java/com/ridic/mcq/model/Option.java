package com.ridic.mcq.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Option {

    @Id
    @GeneratedValue
    @Getter
    private Integer oid;

    @Getter
    @Setter
    @Column
    private String text;

    @Getter
    @Setter
    @Column(name = "qid")
    private Integer qid;

    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.LAZY)
    @JoinColumn(name = "qid", insertable = false, updatable = false)
    private Question question;

    @Column
    @Getter
    @Setter
    private Boolean isCorrect;

}
