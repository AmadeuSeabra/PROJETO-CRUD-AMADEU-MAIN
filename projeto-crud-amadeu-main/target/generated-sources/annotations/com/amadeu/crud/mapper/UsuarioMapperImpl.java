package com.amadeu.crud.mapper;

import com.amadeu.crud.dto.UsuarioDto;
import com.amadeu.crud.model.UsuarioModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-13T23:10:02-0300",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.40.0.z20241112-1021, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public UsuarioDto toDto(UsuarioModel entity) {
        if ( entity == null ) {
            return null;
        }

        UsuarioDto usuarioDto = new UsuarioDto();

        usuarioDto.setEmail( entity.getEmail() );
        usuarioDto.setId( entity.getId() );
        usuarioDto.setNome( entity.getNome() );
        usuarioDto.setSenha( entity.getSenha() );
        usuarioDto.setTelefone( entity.getTelefone() );

        return usuarioDto;
    }

    @Override
    public UsuarioModel toModel(UsuarioDto dto) {
        if ( dto == null ) {
            return null;
        }

        UsuarioModel usuarioModel = new UsuarioModel();

        usuarioModel.setEmail( dto.getEmail() );
        usuarioModel.setId( dto.getId() );
        usuarioModel.setNome( dto.getNome() );
        usuarioModel.setSenha( dto.getSenha() );
        usuarioModel.setTelefone( dto.getTelefone() );

        return usuarioModel;
    }

    @Override
    public List<UsuarioDto> toDtoList(List<UsuarioModel> entity) {
        if ( entity == null ) {
            return null;
        }

        List<UsuarioDto> list = new ArrayList<UsuarioDto>( entity.size() );
        for ( UsuarioModel usuarioModel : entity ) {
            list.add( toDto( usuarioModel ) );
        }

        return list;
    }

    @Override
    public List<UsuarioModel> toModelList(List<UsuarioDto> dto) {
        if ( dto == null ) {
            return null;
        }

        List<UsuarioModel> list = new ArrayList<UsuarioModel>( dto.size() );
        for ( UsuarioDto usuarioDto : dto ) {
            list.add( toModel( usuarioDto ) );
        }

        return list;
    }
}
