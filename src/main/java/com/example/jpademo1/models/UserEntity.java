package com.example.jpademo1.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
public class UserEntity {
    @Id
    @GeneratedValue

 //   @Column(name = "id")
    private int id;
  //  @Column(name = "username")
    private String username;
 //   @Column(name = "password")
    private String password;
 //   @Column(name = "email")
    private String email;
}
