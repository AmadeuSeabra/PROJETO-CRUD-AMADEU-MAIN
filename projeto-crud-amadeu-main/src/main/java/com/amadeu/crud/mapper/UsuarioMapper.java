package com.amadeu.crud.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.amadeu.crud.dto.UsuarioDto;
import com.amadeu.crud.model.UsuarioModel;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    // Converte entidade para DTO
    UsuarioDto toDto(UsuarioModel entity);

    // Converte DTO para entidade
    UsuarioModel toModel(UsuarioDto dto);

    // Converte a lista de entidades para lista de DTOs
    List<UsuarioDto> toDtoList(List<UsuarioModel> entity);

    // Converte lista de DTOs para lista de entidades
    List<UsuarioModel> toModelList(List<UsuarioDto> dto);
}
