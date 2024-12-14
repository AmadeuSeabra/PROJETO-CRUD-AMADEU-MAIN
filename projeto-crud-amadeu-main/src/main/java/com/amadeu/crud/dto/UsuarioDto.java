package com.amadeu.crud.dto;

import lombok.Data;

@Data
public class UsuarioDto {

    private Integer id;

    private String nome;

    private String email;

    private String senha;

    private String telefone;
}
