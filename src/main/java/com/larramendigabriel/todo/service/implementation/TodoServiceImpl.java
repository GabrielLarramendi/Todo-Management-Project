package com.larramendigabriel.todo.service.implementation;

import com.larramendigabriel.todo.dto.TodoDTO;
import com.larramendigabriel.todo.exception.ResourceNotFoundException;
import com.larramendigabriel.todo.model.Todo;
import com.larramendigabriel.todo.repository.TodoRepository;
import com.larramendigabriel.todo.service.TodoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;
    private ModelMapper modelMapper;

    @Override
    public TodoDTO addTodo(TodoDTO todoDTO) {
        //First convert DTO to JPA Entity to save in database
        Todo todoJPA = modelMapper.map(todoDTO, Todo.class);
        //Save de Object in database
        Todo savedTodoJPA = todoRepository.save(todoJPA);
        //Now convertTodo JPA Entity to DTO in order to return a DTO object
        TodoDTO savedTodoDTO = modelMapper.map(savedTodoJPA, TodoDTO.class);

        return savedTodoDTO;
    }

    @Override
    public TodoDTO getTodoById(Long id) {
        Todo TodoJPA = todoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("To-do not found with the id: " + id)
        );
        TodoDTO todoDTO = modelMapper.map(TodoJPA, TodoDTO.class);

        return todoDTO;
    }

    @Override
    public List<TodoDTO> getAllTodos() {
        List<Todo> todoList = todoRepository.findAll();
        List<TodoDTO> todoDTOList = todoList.stream().map((todo) -> modelMapper.map(todo, TodoDTO.class)).toList();
        return todoDTOList;
    }

    @Override
    public TodoDTO updateTodo(TodoDTO todoDTO, Long id) {
        Todo todoJPA = todoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("To-do not found with the id: " + id)
        );
        todoJPA.setTitle(todoDTO.getTitle());
        todoJPA.setDescription(todoDTO.getDescription());
        todoJPA.setCompleted(todoDTO.getCompleted());
        Todo updatedTodo = todoRepository.save(todoJPA);

        return modelMapper.map(updatedTodo, TodoDTO.class);
    }

    @Override
    public void deleteTodo(Long id) {
        Todo todoJPA = todoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("To-do not found with the id: " + id)
        );
        todoRepository.deleteById(id);
    }

    @Override
    public TodoDTO completeTodo(Long id) {
        Todo todoJPA = todoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("To-do not found with the id: " + id)
        );

        todoJPA.setCompleted(true);
        Todo updatedTodo = todoRepository.save(todoJPA);

        return modelMapper.map(updatedTodo, TodoDTO.class);
    }
}
