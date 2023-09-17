package com.github.usermanagement.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

/**
 * Created by Mahsa.Hadiyan  Date: 9/12/2023   Time: 11:58 AM
 **/
@Entity
@Table(name = "Users")
@Data
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "USER_NAME")
    private String userName;


    @Column(name = "PASSWORD")
    private String password;


}
