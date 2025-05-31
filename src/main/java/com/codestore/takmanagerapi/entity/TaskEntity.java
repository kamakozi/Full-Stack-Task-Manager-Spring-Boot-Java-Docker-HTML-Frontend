package com.codestore.takmanagerapi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tasks")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private boolean isCompleted;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}