package com.biblioteca.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Utilizador implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String nome;
    private String email;
    private String perfil;

    @Temporal(TemporalType.DATE)
    @Column
    private Date dataCriacao;

    @Enumerated(EnumType.STRING)
    private SituacaoUtilizador situacaoUtilizador;

    @OneToMany(mappedBy = "utilizador", cascade = CascadeType.ALL)
    private List<Livro> livros;

    public Utilizador() {}

    public Utilizador(final String nome, final String email, final String perfil, final Date dataCriacao, SituacaoUtilizador situacaoUtilizador) {
        this.nome = nome;
        this.email = email;
        this.perfil = perfil;
        this.dataCriacao = dataCriacao;
        this.situacaoUtilizador = situacaoUtilizador;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(final String perfil) {
        this.perfil = perfil;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(final Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public SituacaoUtilizador getSituacaoUtilizador() {
        return situacaoUtilizador;
    }

    public void setSituacaoUtilizador(final SituacaoUtilizador situacaoUtilizador) {
        this.situacaoUtilizador = situacaoUtilizador;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(final List<Livro> livros) {
        this.livros = livros;
    }
}
