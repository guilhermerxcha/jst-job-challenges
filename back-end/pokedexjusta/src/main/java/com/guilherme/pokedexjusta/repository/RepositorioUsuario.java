package com.guilherme.pokedexjusta.repository;

import com.guilherme.pokedexjusta.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, Integer> {

    Usuario obterPorEmail(String email);
}
