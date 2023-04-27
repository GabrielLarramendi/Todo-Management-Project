package com.larramendigabriel.todo.service;

import com.larramendigabriel.todo.dto.TodoDTO;

import java.util.List;

public interface TodoService {

    TodoDTO addTodo(TodoDTO todoDTO);

    TodoDTO getTodoById(Long id);

    List<TodoDTO> getAllTodos();

    TodoDTO updateTodo(TodoDTO todoDTO, Long id);

    void deleteTodo(Long id);
}
