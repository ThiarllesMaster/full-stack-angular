package com.biblioteca.controller;

import com.biblioteca.entity.Utilizador;
import com.biblioteca.model.UtilizadorDTO;
import com.biblioteca.service.UtilizadorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/utilizadores")
public class UtilizadorController {

    @Autowired
    UtilizadorService utilizadorService;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Utilizador>> buscarUtilizadores() {
        List<Utilizador> utilizadores = utilizadorService.buscarUtilizadores();
        return new ResponseEntity<>(utilizadores, HttpStatus.OK);
    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> inativarUtilizador(@RequestBody UtilizadorDTO utilizador) {
        return new ResponseEntity<>(utilizadorService.inativarUtilizador(utilizador), HttpStatus.OK);
    }
}
