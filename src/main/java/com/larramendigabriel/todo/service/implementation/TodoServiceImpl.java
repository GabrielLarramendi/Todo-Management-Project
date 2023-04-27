package com.larramendigabriel.todo.service.implementation;

import com.larramendigabriel.todo.dto.TodoDTO;
import com.larramendigabriel.todo.model.Todo;
import com.larramendigabriel.todo.repository.TodoRepository;
import com.larramendigabriel.todo.service.TodoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;
    private ModelMapper modelMapper;

    @Override
    public TodoDTO addTodo(TodoDTO todoDTO) {

        //First convert DTO to JPA Entity to save in database
        Todo todoJPA = modelMapper.map(todoDTO, Todo.class);
        //Then save de Object in database
        Todo savedTodoJPA = todoRepository.save(todoJPA);

        //Now convertTodo JPA Entity to DTO in order to return a DTO object
        TodoDTO savedTodoDTO = modelMapper.map(savedTodoJPA, TodoDTO.class);

        return savedTodoDTO;
    }
}
