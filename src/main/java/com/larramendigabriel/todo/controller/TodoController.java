package com.larramendigabriel.todo.controller;

import com.larramendigabriel.todo.dto.TodoDTO;
import com.larramendigabriel.todo.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


}
