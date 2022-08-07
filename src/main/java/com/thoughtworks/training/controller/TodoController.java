package com.thoughtworks.training.controller;

import com.thoughtworks.training.model.entity.Todo;
import com.thoughtworks.training.repository.TodoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Resource
    private TodoRepository todoRepository;

    @GetMapping
    public List<Todo> getAll() {
        return todoRepository.findAll();
    }

    @GetMapping("/{todoId}")
    public Todo getTodoById(@PathVariable("todoId") String todoId) throws Exception {
        return todoRepository.findById(todoId).orElseThrow(Exception::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Todo create(@RequestBody Todo todo) {
        todo.setId(UUID.randomUUID().toString());
        return todoRepository.save(todo);
    }

    @DeleteMapping("/{todoId}")
    public void delete(@PathVariable("todoId") String todoId) throws Exception {
        Todo todo = todoRepository.findById(todoId).orElseThrow(Exception::new);
        todoRepository.delete(todo);
    }
}
