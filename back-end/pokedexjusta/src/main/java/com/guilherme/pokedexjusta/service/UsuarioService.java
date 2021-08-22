package com.guilherme.pokedexjusta.service;

import com.guilherme.pokedexjusta.dto.UsuarioDTO;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsuarioService {
    UsuarioDTO criarNovoUsuario(UsuarioDTO usuarioDTO);

    UsuarioDTO editarUsuario(UsuarioDTO usuarioDTO);

    void deletarUsuarioPorId(int id) throws NotFoundException;

    List<UsuarioDTO> obterTodosUsuarios();

    UsuarioDTO obterUsuarioPorId(int id) throws NotFoundException;
}
