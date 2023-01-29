package com.pbamal.springmongo.service;

import com.pbamal.springmongo.model.Task;
import com.pbamal.springmongo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    public Task addTask(Task task){
        task.setTaskId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(task);
    }

    public List<Task> findAllTasks(){
        return repository.findAll();
    }

    public Task findTaskbyId(String id){
        return repository.findById(id).get();
    }

    public List<Task> findTaskbySeverity(int severity){
        return repository.findBySeverity(severity);
    }

    public List<Task> findTaskbyAssignee(String assignee){
        return repository.getTaskByAssignee(assignee);
    }

    public Task updateTask(Task taskRequest){
        Task existingTask = repository.findById(taskRequest.getTaskId()).get();
        existingTask.setAssignee(taskRequest.getAssignee());
        existingTask.setDescription(taskRequest.getDescription());
        existingTask.setSeverity(taskRequest.getSeverity());
        existingTask.setStoryPoint(taskRequest.getStoryPoint());
        return repository.save(existingTask);
    }

    public String deleteById(String id){
        repository.deleteById(id);
        return "Task deleted";
    }
}
