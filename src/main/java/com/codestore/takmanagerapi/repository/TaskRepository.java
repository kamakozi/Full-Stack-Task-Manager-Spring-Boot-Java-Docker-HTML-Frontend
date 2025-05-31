package com.codestore.takmanagerapi.repository;

import com.codestore.takmanagerapi.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<TaskEntity,Long> {
    List<TaskEntity> findByUserId(Long userId);
}
