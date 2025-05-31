package com.codestore.takmanagerapi.controller;

import com.codestore.takmanagerapi.entity.TaskEntity;
import com.codestore.takmanagerapi.Service.TaskService.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/create/{userId}")
    public TaskEntity createTask(@RequestBody TaskEntity task, @PathVariable Long userId) {
        return taskService.createTask(task, userId);
    }

    @GetMapping("/user/{userId}")
    public List<TaskEntity> getTasksByUser(@PathVariable Long userId) {
        return taskService.getTasksByUser(userId);
    }

    @DeleteMapping("/delete/{taskId}")
    public void deleteTask(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);
    }

    @PutMapping("/update")
    public TaskEntity updateTask(@RequestBody TaskEntity task) {
        return taskService.updateTask(task);
    }
}