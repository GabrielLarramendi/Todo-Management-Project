package com.larramendigabriel.todo.controller;

import com.larramendigabriel.todo.dto.TodoDTO;
import com.larramendigabriel.todo.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/todos")
@AllArgsConstructor
public class TodoController {

    private TodoService todoService;

    @PostMapping
    public ResponseEntity<TodoDTO> addTodo(@RequestBody TodoDTO todoDTO) {
        TodoDTO savedTodoDTO = todoService.addTodo(todoDTO);
        return new ResponseEntity<>(savedTodoDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoDTO> getTodoById(@PathVariable("id") Long id) {
        TodoDTO todoDTO = todoService.getTodoById(id);
        return new ResponseEntity<>(todoDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TodoDTO>> getAllTodos() {
        List<TodoDTO> todoDTOList = todoService.getAllTodos();
        return new ResponseEntity<>(todoDTOList, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoDTO> updateTodo(@RequestBody TodoDTO todoDTO, @PathVariable Long id) {
        TodoDTO updatedDataTodoDTO = todoService.updateTodo(todoDTO, id);
        return new ResponseEntity<>(updatedDataTodoDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return new ResponseEntity<>("To-do successfully deleted!", HttpStatus.OK);
    }

    @PatchMapping("/{id}/complete")
    public ResponseEntity<TodoDTO> completeTodo(@PathVariable Long id) {
        TodoDTO updatedTodoDTO = todoService.completeTodo(id);
        return new ResponseEntity<>(updatedTodoDTO, HttpStatus.OK);
    }

    @PatchMapping("/{id}/incomplete")
    public ResponseEntity<TodoDTO> incompleteTodo(@PathVariable Long id) {
        TodoDTO updatedDTO = todoService.incompleteTodo(id);
        return new ResponseEntity<>(updatedDTO, HttpStatus.OK);
    }
}
