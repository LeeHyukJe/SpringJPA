package com.victolee.guestbook.domain;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="guestbook")
public class GuestBook {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer no;

    @Column(name="name", nullable=false, length=100)
    private String name;

    @Column(name="pwd", nullable=false, length=64)
    private String pwd;

    @Column(name="message", nullable=false)
    private String message;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="reg_date", nullable=false)
    private Date regDate;

    // getter setter 생략
}
