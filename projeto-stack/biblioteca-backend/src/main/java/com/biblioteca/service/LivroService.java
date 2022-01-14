package com.biblioteca.service;

import com.biblioteca.entity.Livro;
import com.biblioteca.repository.LivroRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

    private LivroRepository livroRepo;

    LivroService(LivroRepository livroRepo) {
        this.livroRepo = livroRepo;
    }

    public Livro adicionarLivro(Livro livro) {
        return livroRepo.save(livro);
    }

    public List<Livro> buscarTodosOsLivros() {
        return livroRepo.findAll();
    }

    public void removerLivro(Long id) {
        livroRepo.deleteById(id);
    }
}