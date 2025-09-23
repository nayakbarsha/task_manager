package com.barsha.taskmanager.service;

import com.barsha.taskmanager.model.Task;
import com.barsha.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService{
    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(Task task){
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> getTaskById(Long id){
        return taskRepository.findById(id);
    }

    @Override
    public void deleteTask(Long id){
        if(!taskRepository.existsById(id)){
            throw new RuntimeException("Task not found");
        }
        taskRepository.deleteById(id);
    }

    @Override
    public Task updateTask(Long id, Task updatedTask){
        return taskRepository.findById(id)
                .map(task -> {
                    task.setTitle(updatedTask.getTitle());
                    task.setDescription(updatedTask.getDescription());
                    return taskRepository.save(task);
                })
                .orElseThrow(()-> new RuntimeException("Task not found"));
    }
}
