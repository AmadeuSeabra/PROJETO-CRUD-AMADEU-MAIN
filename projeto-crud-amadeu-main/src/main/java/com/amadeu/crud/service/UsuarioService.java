package com.amadeu.crud.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.amadeu.crud.dto.UsuarioDto;
import com.amadeu.crud.mapper.UsuarioMapper;
import com.amadeu.crud.model.UsuarioModel;
import com.amadeu.crud.repository.UsuarioRepository;

import java.util.List;

@Slf4j
@Service
public class UsuarioService {

    final UsuarioRepository usuarioRepository;
    final UsuarioMapper usuarioMapper;

    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    public UsuarioDto create(UsuarioDto dto) {
        log.info("UsuarioService::create");

        UsuarioModel usuarioModel = usuarioMapper.toModel(dto); // Conversão do DTO para Model
        UsuarioModel usuarioGravado = usuarioRepository.save(usuarioModel); // Persistência no banco
        return usuarioMapper.toDto(usuarioGravado); // Conversão do Model para DTO
    }

    public UsuarioDto read(Integer id) {
        log.info("UsuarioService::read(id)");

        UsuarioModel usuarioPesquisado = usuarioRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Usuário com o ID fornecido não existe: " + id));

        return usuarioMapper.toDto(usuarioPesquisado); // Conversão do Model para DTO
    }

    public List<UsuarioDto> read() {
        log.info("UsuarioService::read()");

        List<UsuarioModel> usuarioModelList = usuarioRepository.findAll();
        return usuarioMapper.toDtoList(usuarioModelList); // Conversão de lista de Models para lista de DTOs
    }

    public UsuarioDto update(Integer id, UsuarioDto dto) {
        log.info("UsuarioService::update(id, dto)");

        UsuarioModel usuarioPesquisado = usuarioRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Usuário com o ID fornecido não existe: " + id));

        // Atualização dos dados do usuário
        usuarioPesquisado.setNome(dto.getNome());
        usuarioPesquisado.setEmail(dto.getEmail());
        usuarioPesquisado.setSenha(dto.getSenha());
        usuarioPesquisado.setTelefone(dto.getTelefone());

        UsuarioModel usuarioAtualizado = usuarioRepository.save(usuarioPesquisado);
        return usuarioMapper.toDto(usuarioAtualizado); // Conversão do Model atualizado para DTO
    }

    public void delete(Integer id) {
        log.info("UsuarioService::delete(id)");

        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuário com o ID fornecido não existe: " + id);
        }
        usuarioRepository.deleteById(id);
    }
}
