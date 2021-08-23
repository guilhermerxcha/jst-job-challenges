package com.guilherme.pokedexjusta.service;

import com.guilherme.pokedexjusta.dto.UsuarioDTO;
import java.util.List;

public interface UsuarioService {
    UsuarioDTO criarNovoUsuario(UsuarioDTO usuarioDTO);

    UsuarioDTO editarUsuario(UsuarioDTO usuarioDTO);

    void deletarUsuarioPorId(int id) ;

    List<UsuarioDTO> obterTodosUsuarios();

    UsuarioDTO obterUsuarioPorId(int id);
}
