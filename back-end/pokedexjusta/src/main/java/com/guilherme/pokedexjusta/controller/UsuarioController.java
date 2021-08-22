package com.guilherme.pokedexjusta.controller;

import com.guilherme.pokedexjusta.dto.UsuarioDTO;
import com.guilherme.pokedexjusta.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @RequestMapping(value = "/novo", method =  RequestMethod.POST)
    public UsuarioDTO criarNovoUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO) {
        return usuarioService.criarNovoUsuario(usuarioDTO);
    }
}
