package com.guilherme.pokedexjusta.controller;

import com.guilherme.pokedexjusta.dto.UsuarioDTO;
import com.guilherme.pokedexjusta.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping(value = "/novousuario")
    public UsuarioDTO criarNovoUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        return this.usuarioService.criarNovoUsuario(usuarioDTO);
    }

    @PutMapping(value = "/editarusuario")
    public UsuarioDTO editarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        return this.usuarioService.editarUsuario(usuarioDTO);
    }

    @DeleteMapping(value = "/{id}")
    public void deletarUsuario( @PathVariable int id) {
        this.usuarioService.deletarUsuarioPorId(id);
    }

    @GetMapping(value = "/obtertodosusuarios")
    public List<UsuarioDTO> buscarTodos() {
        return this.usuarioService.obterTodosUsuarios();
    }

    @GetMapping(value = "/{id}")
    public UsuarioDTO obterUsuarioPorId(@PathVariable int id) {
        return this.usuarioService.obterUsuarioPorId(id);
    }

    @GetMapping(value = "/{email}")
    public UsuarioDTO obterUsuarioPorEmail(@PathVariable String email) {
        return this.usuarioService.obterUsuarioPorEmail(email);
    }

    @DeleteMapping(value = "/deletartodos")
    public void deletarTodosUsuarios() {
        this.usuarioService.deletarTodosUsuarios();
    }
}
