package com.larramendigabriel.todo.service;

import com.larramendigabriel.todo.dto.TodoDTO;

public interface TodoService {

    TodoDTO addTodo(TodoDTO todoDTO);

    TodoDTO getTodoById(Long id);

}
