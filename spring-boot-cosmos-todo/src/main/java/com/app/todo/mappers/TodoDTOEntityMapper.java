package com.app.todo.mappers;

import com.app.todo.domain.Todo;
import com.app.todo.dto.TodoDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TodoDTOEntityMapper {
    Todo dtoToEntity(TodoDTO dto);

    TodoDTO entityToDto(Todo entity);

    List<TodoDTO> mapListEntityToDto(List<Todo> entities);
}
