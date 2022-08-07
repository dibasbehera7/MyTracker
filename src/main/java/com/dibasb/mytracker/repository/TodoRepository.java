package com.dibasb.mytracker.repository;

import com.dibasb.mytracker.entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
    List<Todo> findByUser(String user);
}
