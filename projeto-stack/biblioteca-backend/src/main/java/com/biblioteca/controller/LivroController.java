package com.biblioteca.controller;

import com.biblioteca.entity.Livro;
import com.biblioteca.service.LivroService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Livro> adicionarLivro(@Valid @RequestBody Livro livro) {
        Livro newLivro = livroService.adicionarLivro(livro);
        return new ResponseEntity<>(newLivro, HttpStatus.CREATED);
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN') || hasRole('UTILIZADOR') || hasRole('ANONIMO')")
    public ResponseEntity<List<Livro>> buscarTodosLivros() {
        List<Livro> todosOsLivros = livroService.buscarTodosOsLivros();
        return new ResponseEntity<>(todosOsLivros, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerLivro(@PathVariable("id") Long id) {
       livroService.removerLivro(id);
       return new ResponseEntity<Void>(HttpStatus.OK);
    }
}