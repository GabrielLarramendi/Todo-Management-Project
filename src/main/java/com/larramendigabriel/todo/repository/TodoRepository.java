package com.larramendigabriel.todo.repository;

import com.larramendigabriel.todo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
