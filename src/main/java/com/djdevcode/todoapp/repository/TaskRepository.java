package com.djdevcode.todoapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.djdevcode.todoapp.model.TaskEntity;

public interface TaskRepository extends JpaRepository<TaskEntity,Long> {

}
