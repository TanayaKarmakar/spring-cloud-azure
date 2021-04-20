package com.app.todo.controller;

import com.app.todo.dto.TodoDTO;
import com.app.todo.exception.ApiException;
import com.app.todo.exception.BusinessException;
import com.app.todo.service.TodoService;
import com.app.todo.util.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {
    @Autowired
    private TodoService todoService;

    private Logger logger = LoggerFactory.getLogger(TodoController.class);

    //get all todo based on username, it should be passed from header
    @GetMapping
    public List<TodoDTO> getTodos(@RequestHeader HttpHeaders headers) throws ApiException {
        if(!headers.containsKey(AppConstants.USER_NAME))
            throw new ApiException(AppConstants.USER_ID_NOT_PRESENT);

        try {
            return todoService.listTodos(headers.get(AppConstants.USER_NAME).get(0));
        } catch(BusinessException exception) {
            throw new ApiException(exception);
        }
    }

    @GetMapping("/{id}")    
    public TodoDTO getTodoById(@RequestHeader HttpHeaders headers, @PathVariable String id) throws ApiException {
        if(!headers.containsKey(AppConstants.USER_NAME))
            throw new ApiException(AppConstants.USER_ID_NOT_PRESENT);
        try {
            String userName = headers.get(AppConstants.USER_NAME).get(0);
            return todoService.getTodoById(userName, id);
        } catch (BusinessException exception) {
            throw new ApiException(exception);
        }
    }

    @PostMapping
    public TodoDTO createTodo(@RequestHeader HttpHeaders headers, @RequestBody TodoDTO todo) throws ApiException {
        if(!headers.containsKey(AppConstants.USER_NAME))
            throw new ApiException(AppConstants.USER_ID_NOT_PRESENT);
        TodoDTO createdTodo = null;
        try {
            String userName = headers.get(AppConstants.USER_NAME).get(0);
            todo.setUserName(userName);
            createdTodo = todoService.createTodo(todo);
        } catch (BusinessException exception) {
            throw new ApiException(exception);
        }

        return createdTodo;
    }

    @PutMapping
    public TodoDTO updateTodo(@RequestHeader HttpHeaders headers, @RequestBody TodoDTO todo) throws ApiException {
        if(!headers.containsKey(AppConstants.USER_NAME))
            throw new ApiException(AppConstants.USER_ID_NOT_PRESENT);
        TodoDTO updatedTodo = null;
        try {
            String userName = headers.get(AppConstants.USER_NAME).get(0);
            todo.setUserName(userName);
            return todoService.updateTodo(todo);
        } catch (BusinessException exception) {
            throw new ApiException(exception);
        }
    }

    @DeleteMapping("/{id}")
    public String deleteTodo(@RequestHeader HttpHeaders headers, @PathVariable String id) throws ApiException {
        if(!headers.containsKey(AppConstants.USER_NAME))
            throw new ApiException(AppConstants.USER_ID_NOT_PRESENT);
        try {
            String userName = headers.get(AppConstants.USER_NAME).get(0);
            todoService.deleteTodo(userName, id);
            return "Success";
        } catch (BusinessException exception) {
            throw new ApiException(exception);
        }
    }
}
