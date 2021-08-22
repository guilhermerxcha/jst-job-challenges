package com.guilherme.pokedexjusta.model;

import com.guilherme.pokedexjusta.dto.UsuarioDTO;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(	name = "jst_usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(max = 20)
    private String nomeUsuario;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(max = 120)
    private String senha;

    public Usuario(String nomeUsuario, String email, String senha) {
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.senha = senha;
    }

    public Usuario() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public static Usuario toEntidade(UsuarioDTO usuarioDTO){
        return new Usuario(usuarioDTO.getNomeUsuario(),usuarioDTO.getEmail(),usuarioDTO.getSenha());
    }

    public UsuarioDTO toDTO(){
        UsuarioDTO usuarioDTO = new UsuarioDTO(nomeUsuario, email,senha);
        usuarioDTO.setId(id);
        return usuarioDTO;
    }
}
