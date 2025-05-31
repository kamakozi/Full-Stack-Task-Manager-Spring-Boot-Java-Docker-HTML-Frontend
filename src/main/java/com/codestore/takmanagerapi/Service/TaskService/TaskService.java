package com.codestore.takmanagerapi.Service.TaskService;

import com.codestore.takmanagerapi.entity.TaskEntity;


import java.util.List;


public interface TaskService {
    TaskEntity createTask(TaskEntity task,Long userId);
    List<TaskEntity>getTasksByUser(Long userId);
    void deleteTask(Long taskId);
    TaskEntity updateTask(TaskEntity task);

            }
