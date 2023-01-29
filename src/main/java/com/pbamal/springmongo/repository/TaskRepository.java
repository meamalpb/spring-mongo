package com.pbamal.springmongo.repository;

import com.pbamal.springmongo.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

//here MongoRepository<Task,String> , Task is the name of the collection and string is the data type of the primary key/ ID
public interface TaskRepository extends MongoRepository<Task,String> {

    List<Task> findBySeverity(int severity);

    @Query("{assignee : ?0}")
    List<Task> getTaskByAssignee(String assignee);
}
