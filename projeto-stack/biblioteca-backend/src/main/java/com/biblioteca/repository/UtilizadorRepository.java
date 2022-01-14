package com.biblioteca.repository;

import com.biblioteca.entity.Utilizador;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UtilizadorRepository extends JpaRepository<Utilizador, Long> {

    @Query("select utilizador from Utilizador utilizador where utilizador.situacaoUtilizador = 'ATIVO' order by utilizador.dataCriacao desc")
    public List<Utilizador> buscarUtilizadores();

    public Utilizador findByNome(String nome);

    @Query("select count(*) from Livro l inner join l.utilizador u where u.nome = :nome")
    public Long quantidadeLivrosReservados(String nome);

}
