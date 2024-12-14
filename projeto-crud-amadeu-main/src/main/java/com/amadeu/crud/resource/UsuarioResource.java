package com.amadeu.crud.resource;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amadeu.crud.dto.UsuarioDto;
import com.amadeu.crud.model.UsuarioModel;
import com.amadeu.crud.service.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/usuarios")
@Tag(name = "usuario", description = "Documentação relacionada ao recurso de usuários")
public class UsuarioResource {

    final UsuarioService usuarioService;

    public UsuarioResource(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Operation(
            summary = "Cria um usuário",
            description = "Método responsável por criar um usuário no sistema")
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = UsuarioModel.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    public UsuarioDto create(@RequestBody UsuarioDto usuarioDto) {
        log.info("UsuarioResource::create");
        return usuarioService.create(usuarioDto);
    }

    @GetMapping(value = "/{id}",
    produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Operation(
            summary = "Recupera um usuário baseado em um identificador",
            description = "Método responsável por recuperar um usuário no sistema baseado no identificador")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = UsuarioModel.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    public UsuarioDto get(@PathVariable Integer id) {
        log.info("UsuarioResource::get(id)");
        return usuarioService.read(id);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    @Operation(
            summary = "Recupera uma lista de usuários",
            description = "Método responsável por recuperar uma lista de usuários")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = UsuarioModel.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    public List<UsuarioDto> get() {
        log.info("UsuarioResource::get()");
        return usuarioService.read();
    }

    @PutMapping(value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Operation(
            summary = "Atualiza todos os dados de um usuário",
            description = "Método responsável por atualizar todos os dados de um usuário.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = UsuarioModel.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    public UsuarioDto update(@PathVariable Integer id, @RequestBody UsuarioDto usuarioDto) {
        log.info("UsuarioResource::update(id,usuarioDto)");
        return usuarioService.update(id, usuarioDto);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(
            summary = "Deleta um usuário com base no identificador",
            description = "Método responsável por deletar um usuário com base no identificador.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", content = { @Content(schema = @Schema(implementation = UsuarioModel.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    public void delete(@PathVariable Integer id) {
        log.info("UsuarioResource::delete(id)");
        usuarioService.delete(id);
    }

}
