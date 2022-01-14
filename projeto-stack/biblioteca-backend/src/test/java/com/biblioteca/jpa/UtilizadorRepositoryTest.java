package com.biblioteca.jpa;

import com.biblioteca.entity.Livro;
import com.biblioteca.entity.SituacaoUtilizador;
import com.biblioteca.entity.Utilizador;
import com.biblioteca.repository.UtilizadorRepository;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UtilizadorRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UtilizadorRepository utilizadorRepository;

    List<Livro> livros = new ArrayList<>();
    Utilizador utilizador = new Utilizador();

    @BeforeEach
    public void setUp() {
        Utilizador utilizador = new Utilizador();
        utilizador.setNome("nomeUtilizador");
        Livro l = new Livro();
        l.setCategoria("Categoria");
        l.setUtilizador(utilizador);
        livros.add(l);
        utilizador.setLivros(livros);
    }

    @Test
    public void buscarUtilizadoresAtivos() {
        List<Utilizador> utilizadores = utilizadorRepository.buscarUtilizadores();
       assertTrue(utilizadores.size() == 1);

    }

    @Test
    public void quantidadeLivrosReservadosTest() {
        entityManager.persist(utilizador);
        entityManager.flush();
        Long count = utilizadorRepository.quantidadeLivrosReservados("Nome");
        assertTrue(count == 1);
    }
}
