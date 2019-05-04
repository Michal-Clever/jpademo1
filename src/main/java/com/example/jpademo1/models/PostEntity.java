package com.example.jpademo1.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "post")
public class PostEntity {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "user_id")
    private int userId;
    private String title;
    private String content;
    @Column(name = "creation_time")
    private LocalDateTime creationTime;
}
