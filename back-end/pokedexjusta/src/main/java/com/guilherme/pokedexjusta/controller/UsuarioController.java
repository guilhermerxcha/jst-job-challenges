package com.guilherme.pokedexjusta.controller;

import com.guilherme.pokedexjusta.dto.UsuarioDTO;
import com.guilherme.pokedexjusta.service.UsuarioService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @ApiOperation(value = "Cria um novo usuario.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Cria um novo usuario."),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PostMapping(value = "/novousuario")
    public UsuarioDTO criarNovoUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        return this.usuarioService.criarNovoUsuario(usuarioDTO);
    }

    @ApiOperation(value = "Edita usuario existente.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Edita usuario existente."),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PutMapping(value = "/editarusuario")
    public UsuarioDTO editarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        return this.usuarioService.editarUsuario(usuarioDTO);
    }

    @ApiOperation(value = "Deleta usuario pelo id.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Deleta usuario pelo id."),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @DeleteMapping(value = "/{id}")
    public void deletarUsuario( @PathVariable int id) {
        this.usuarioService.deletarUsuarioPorId(id);
    }

    @ApiOperation(value = "Retorna a lista de usuarios.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a lista de usuarios."),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping(value = "/obtertodosusuarios")
    public List<UsuarioDTO> buscarTodos() {
        return this.usuarioService.obterTodosUsuarios();
    }

    @ApiOperation(value = "Obtem usário pelo id.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Obtem usário pelo id."),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping(value = "/{id}")
    public UsuarioDTO obterUsuarioPorId(@PathVariable int id) {
        return this.usuarioService.obterUsuarioPorId(id);
    }

    @ApiOperation(value = "Retorna usuario a partir do email na busca.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna usuario a partir do email na busca."),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping(value = "/{email}")
    public UsuarioDTO obterUsuarioPorEmail(@PathVariable String email) {
        return this.usuarioService.obterUsuarioPorEmail(email);
    }

    @ApiOperation(value = "Deleta todos os usuários.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Deleta todos os usuários."),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @DeleteMapping(value = "/deletartodos")
    public void deletarTodosUsuarios() {
        this.usuarioService.deletarTodosUsuarios();
    }
}
