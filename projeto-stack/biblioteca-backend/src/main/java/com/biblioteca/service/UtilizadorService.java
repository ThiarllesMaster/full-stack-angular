package com.biblioteca.service;

import com.biblioteca.entity.SituacaoUtilizador;
import com.biblioteca.entity.Utilizador;
import com.biblioteca.model.UtilizadorDTO;
import com.biblioteca.repository.UtilizadorRepository;
import java.util.List;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UtilizadorService {

    private UtilizadorRepository utilizadorRepository;

    UtilizadorService(UtilizadorRepository utilizadorRepository) {
        this.utilizadorRepository = utilizadorRepository;
    }

    public List<Utilizador> buscarUtilizadores() {
        return utilizadorRepository.buscarUtilizadores();
    }

    public String inativarUtilizador(UtilizadorDTO utilizadorDTO) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        String username = userDetails.getUsername();
        if (username.equals(utilizadorDTO.getUsername())) {
            return "Você não pode se inativar";
        } else {
            Utilizador utilizador = utilizadorRepository.findByNome(utilizadorDTO.getUsername());
            long livrosReservados = utilizadorRepository.quantidadeLivrosReservados(utilizadorDTO.getUsername());
            if (livrosReservados > 0 ) {
                return "Utilizador possui livros alugados. Não foi possivel inativar";
            }
            utilizador.setSituacaoUtilizador(SituacaoUtilizador.INATIVO);
            utilizadorRepository.save(utilizador);
            return "Operação realizada com sucesso";
        }
    }
}
