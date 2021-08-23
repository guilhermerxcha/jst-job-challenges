package com.guilherme.pokedexjusta.repository;

import com.guilherme.pokedexjusta.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, Integer> {

    @Query("SELECT usuario.email FROM Usuario usuario where usuario.email = :email ")
    Usuario obtemPorEmail(@Param("email") String email);

}
