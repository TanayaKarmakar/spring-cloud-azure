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
import java.util.UUID;

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
            logger.info("Fetching todos has started");
            List<Todo> todos = todoRepository.findTodosByUserName(userName);
            todoDTOS = todoDTOEntityMapper.mapListEntityToDto(todos);
            logger.info("Fetching todos has finished");
        } catch (Exception exception) {
            logger.error("An error occurred while trying to fetch todo");
        }
        return todoDTOS;
    }

    @Override
    public TodoDTO getTodoById(String userName, String id) throws BusinessException {
        TodoDTO todoDTO = null;
        try {
            logger.info("Fetching todo has started by Username: {}, Id: {}", userName, id);
            Todo todo = todoRepository.findTodoByUserNameAndId(userName, id);
            todoDTO = todoDTOEntityMapper.entityToDto(todo);
            logger.info("Fetching todo has finished by Username: {}, Id: {}", userName, id);
        } catch (Exception exception) {
            logger.info("An error occurred while trying to fetch the todo details ", exception);
        }
        return todoDTO;
    }

    @Override
    public TodoDTO createTodo(TodoDTO todo) throws BusinessException {
        TodoDTO updatedTodo = null;
        try {
            logger.info("Todo creation has started");
            todo.setId(UUID.randomUUID().toString());
            Todo todoEntity = todoDTOEntityMapper.dtoToEntity(todo);
            todoEntity = todoRepository.save(todoEntity);
            updatedTodo = todoDTOEntityMapper.entityToDto(todoEntity);
            logger.info("Todo creation has finished");
        } catch(Exception exception) {
            logger.error("An error occurred while creating todo ", exception);
        }
        return updatedTodo;
    }

    @Override
    public TodoDTO updateTodo(TodoDTO todo) throws BusinessException {
        TodoDTO updatedTodo = null;
        try {
            logger.info("Todo updation has started");
            Todo todoEntity = todoDTOEntityMapper.dtoToEntity(todo);
            todoEntity = todoRepository.save(todoEntity);
            updatedTodo = todoDTOEntityMapper.entityToDto(todoEntity);
            logger.info("Todo updation has finished");
        } catch (Exception exception) {
            logger.error("An error occurred while updating todo ", exception);
        }
        return updatedTodo;
    }


    @Override
    public void deleteTodo(String userName, String id) throws BusinessException {
        try {
            logger.info("Todo deletion has started");
            Todo todoEntity = todoRepository.findTodoByUserNameAndId(userName, id);
            todoRepository.delete(todoEntity);
            logger.info("Todo deletion has finished");
        } catch (Exception exception) {
            logger.error("An error occurred while deleting todo ", exception);
        }
    }
}
