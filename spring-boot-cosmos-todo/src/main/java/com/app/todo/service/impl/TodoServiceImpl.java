package com.app.todo.service.impl;

import com.app.todo.domain.Todo;
import com.app.todo.dto.TodoDTO;
import com.app.todo.exception.BusinessException;
import com.app.todo.mappers.TodoDTOEntityMapper;
import com.app.todo.repository.TodoRepository;
import com.app.todo.service.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {
    private Logger logger = LoggerFactory.getLogger(TodoServiceImpl.class);

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private TodoDTOEntityMapper todoDTOEntityMapper;

    @Override
    public List<TodoDTO> listTodos(String userName) throws BusinessException {
        List<TodoDTO> todoDTOS = null;
        try {
            logger.info("Fetcing todos has started");
            List<Todo> todos = todoRepository.findTodosByUserName(userName);
            todoDTOS = todoDTOEntityMapper.mapListEntityToDto(todos);
        } catch (Exception exception) {
            logger.error("An error occurred while trying to fetch todo");
        }
        return todoDTOS;
    }

    @Override
    public Todo getTodoById(String userName, String id) throws BusinessException {
        return null;
    }

    @Override
    public TodoDTO createTodo(TodoDTO todo) throws BusinessException {
        return null;
    }

    @Override
    public Todo updateTodo(String userName, TodoDTO todo) throws BusinessException {
        return null;
    }


    @Override
    public Todo deleteTodo(String userName, String id) throws BusinessException {
        return null;
    }
}
