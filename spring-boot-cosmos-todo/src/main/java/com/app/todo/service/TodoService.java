package com.app.todo.service;

import com.app.todo.domain.Todo;
import com.app.todo.dto.TodoDTO;
import com.app.todo.exception.BusinessException;

import java.util.List;

public interface TodoService {
    List<TodoDTO> listTodos(String userName) throws BusinessException;

    Todo getTodoById(String userName, String id) throws BusinessException;

    TodoDTO createTodo(TodoDTO todo) throws BusinessException;

    Todo updateTodo(String userName, TodoDTO todo) throws BusinessException;

    Todo deleteTodo(String userName, String id) throws BusinessException;
}
