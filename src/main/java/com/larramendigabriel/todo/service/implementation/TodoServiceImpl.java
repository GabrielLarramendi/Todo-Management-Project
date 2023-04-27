package com.larramendigabriel.todo.service.implementation;

import com.larramendigabriel.todo.dto.TodoDTO;
import com.larramendigabriel.todo.model.Todo;
import com.larramendigabriel.todo.repository.TodoRepository;
import com.larramendigabriel.todo.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;

    @Override
    public TodoDTO addTodo(TodoDTO todoDTO) {

        //First convert DTO to JPA Entity to save in database
        Todo todoJPA = new Todo();
        todoJPA.setTitle(todoDTO.getTitle());
        todoJPA.setDescription(todoDTO.getDescription());
        todoJPA.setCompleted(todoDTO.getCompleted());

        //Then save de Object in database
        Todo savedTodoJPA = todoRepository.save(todoJPA);

        //Now convertTodo JPA Entity to DTO in order to return a DTO object
        TodoDTO savedTodoDTO = new TodoDTO();
        savedTodoDTO.setId(savedTodoJPA.getId());
        savedTodoDTO.setTitle(savedTodoJPA.getTitle());
        savedTodoDTO.setDescription(savedTodoJPA.getDescription());
        savedTodoDTO.setCompleted(savedTodoJPA.getCompleted());

        return savedTodoDTO;
    }
}
