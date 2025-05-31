package com.codestore.takmanagerapi.Service.TaskService;

import com.codestore.takmanagerapi.entity.TaskEntity;
import com.codestore.takmanagerapi.entity.UserEntity;
import com.codestore.takmanagerapi.repository.TaskRepository;
import com.codestore.takmanagerapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public TaskEntity createTask(TaskEntity task, Long userId) {
        UserEntity user = userRepository.findById(userId).orElseThrow();
        task.setUser(user);
        return taskRepository.save(task);
    }

    @Override
    public List<TaskEntity> getTasksByUser(Long userId) {
        return taskRepository.findByUserId(userId);
    }

    @Override
    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }

    @Override
    public TaskEntity updateTask(TaskEntity task) {
        return taskRepository.save(task);
    }

}