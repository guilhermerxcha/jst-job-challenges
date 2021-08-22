package com.guilherme.pokedexjusta.service;

import com.guilherme.pokedexjusta.dto.UsuarioDTO;
import com.guilherme.pokedexjusta.model.Usuario;
import com.guilherme.pokedexjusta.repository.RepositorioUsuario;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioServiceimpl implements UsuarioService{

    @Autowired
    RepositorioUsuario repositorioUsuario;

    @Override
    public UsuarioDTO criarNovoUsuario(UsuarioDTO usuarioDTO) {
        validaInformacoesBasicas(usuarioDTO);
        validaSenha(usuarioDTO);

        this.repositorioUsuario.save(Usuario.toEntidade(usuarioDTO));
        return usuarioDTO;
    }

    private void validaSenha(UsuarioDTO usuarioDTO) {
        if (usuarioDTO.getSenha() == null){
            throw new RuntimeException("Senha é requerida.");
        }
    }

    private void validaInformacoesBasicas(UsuarioDTO usuarioDTO) {
        if (usuarioDTO == null) {
            throw new RuntimeException("Usuário é requerido.");
        }
        if (usuarioDTO.getNomeUsuario() == null) {
            throw new RuntimeException("Nome do usuario é requerido.");
        }
        if (usuarioDTO.getEmail() == null) {
            throw new RuntimeException("Email é requerido.");
        }
    }

    @Override
    public UsuarioDTO editarUsuario(UsuarioDTO usuarioDTO) {
        validaInformacoesBasicas(usuarioDTO);

        this.repositorioUsuario.save(Usuario.toEntidade(usuarioDTO));
        return usuarioDTO;
    }

    @Override
    public void deletarUsuarioPorId(int id) throws NotFoundException {

        Optional.ofNullable(this.repositorioUsuario.getById(id))
                .map(usuario -> {
                    repositorioUsuario.delete(usuario);
                    return usuario;
                }).orElseThrow(() -> new NotFoundException("Usuario não encontrado."));
    }

    @Override
    public List<UsuarioDTO> obterTodosUsuarios() {
        List<UsuarioDTO> list = new ArrayList<>();
        this.repositorioUsuario.findAll().forEach(usuario -> list.add(usuario.toDTO()));
        return list;
    }

    public UsuarioDTO obterUsuarioPorId(int id) throws NotFoundException {
        return Optional
                .ofNullable(this.repositorioUsuario.getById(id))
                .map(Usuario::toDTO)
                .orElseThrow(() -> new NotFoundException("Usuario não encontrado."));
    }
}
