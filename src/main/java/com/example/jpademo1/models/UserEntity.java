package com.example.jpademo1.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table (name = "user")
@Data
public class UserEntity {
    @Id
    @GeneratedValue
    private int id;
    private String username;
    private String password;

  //  @Column(name = "email")
    private String email;
}
