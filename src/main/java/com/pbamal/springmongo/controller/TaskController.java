package com.pbamal.springmongo.controller;

import com.pbamal.springmongo.model.Task;
import com.pbamal.springmongo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTask(@RequestBody Task task){
        System.out.println("Adding tasks");
        return taskService.addTask(task);
    }

    @GetMapping
    public List<Task> getTasks(){
        System.out.println("Getting tasks");
        return taskService.findAllTasks();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable String id){
        return taskService.findTaskbyId(id);
    }

    @GetMapping("/severity/{severity}")
    public List<Task> getTaskBySeverity(@PathVariable int severity){
        return taskService.findTaskbySeverity(severity);
    }

    @GetMapping("/assignee/{assignee}")
    public List<Task> getTaskByAssignee(@PathVariable String assignee){
        return taskService.findTaskbyAssignee(assignee);
    }

    @PutMapping
    public Task updateTask(@RequestBody Task task){
        return taskService.updateTask(task);
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable String id){
        return taskService.deleteById(id);
    }




}
