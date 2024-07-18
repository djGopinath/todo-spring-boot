package com.djdevcode.todoapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.djdevcode.todoapp.model.TaskEntity;
import com.djdevcode.todoapp.repository.TaskRepository;

@RestController
@CrossOrigin
@RequestMapping("/api/task")
public class TaskController {
	
	@Autowired
	private TaskRepository taskRepository;

	@GetMapping("/hello-world")
	public String helloworld() {
		return "Hello World From dj Dev Code...";
	}
	
	//post api 
	@PostMapping
	public TaskEntity createTask(@RequestBody TaskEntity taskData) {
		taskRepository.save(taskData);
		return taskData;
	}
	
	//get all api
	@GetMapping
	public List<TaskEntity> getAllTask() {
		return taskRepository.findAll();
	}
	
	//update Api
	@PutMapping("/{id}")
	public TaskEntity updateTask(@PathVariable Long id,@RequestBody TaskEntity taskData) {
		taskData.setId(id);
		return taskRepository.save(taskData);
	}
	
	//delete Api
		@DeleteMapping("/{id}")
		public void deleteTask(@PathVariable Long id) {
			taskRepository.deleteById(id);
		}
}
	