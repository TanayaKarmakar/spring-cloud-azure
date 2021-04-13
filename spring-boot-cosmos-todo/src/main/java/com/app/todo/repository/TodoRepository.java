package com.app.todo.repository;

import com.app.todo.domain.Todo;
import com.azure.spring.data.cosmos.repository.CosmosRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TodoRepository extends CosmosRepository<Todo, String> {
    @Query(value = "select * from c where c.userName = @userName")
    List<Todo> findTodosByUserName(@Param("userName") String userName);

    @Query(value = "select * from c where c.userName = @userName and c.id = @id")
    Todo findTodoByUserNameAndId(@Param("userName") String userName, @Param("id") String id);
}
