package com.barsha.taskmanager.service;

import com.barsha.taskmanager.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    Task createTask(Task task);
    List<Task> getAllTasks();
    Optional<Task> getTaskById(Long id);
    void deleteTask(Long id);
    Task updateTask(Long id, Task updatedTask);
}
