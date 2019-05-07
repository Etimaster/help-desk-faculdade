package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pichau
 */

@Entity
@NamedQueries({
    @NamedQuery(name = "Chamado.getAll", query = "select c from Chamado c")
    ,
    @NamedQuery(name = "Chamado.atendente", query = "select c from Chamado c where c.atendente= :atendente")
    ,
    @NamedQuery(name = "Chamado.solicitador", query = "select c from Chamado c where c.solicitador= :solicitador")
    ,
    @NamedQuery(name = "Chamado.naoAtendidos", query = "select c from Chamado c where c.atendente IS NULL")
    ,
    @NamedQuery(name = "Chamado.getBySituacao", query = "select c from Chamado c where c.situacao= :situacao")
        
})
public class Chamado implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    private Usuario criador;
    @OneToOne
    private Usuario solicitador;
    @OneToOne
    private Atendente atendente;
    private String titulo;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private Classificacao classificacao;
    private LocalDateTime dataDeCriacao;
    private LocalDateTime dataLimite;
    @Enumerated(EnumType.STRING)
    private Situacao situacao;
    private String resolucao;
    @OneToOne
    private Equipe equipeResponsavel;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    public Chamado() {
    }

    public Chamado(Integer id, Usuario criador, Usuario solicitador, String titulo, String descricao, Categoria categoria) {
        this.id = id;
        this.criador = criador;
        this.solicitador = solicitador;
        this.titulo = titulo;
        this.descricao = descricao;
        this.categoria = categoria;
        this.dataDeCriacao = LocalDateTime.now();
        this.dataLimite = LocalDateTime.now();
        this.situacao = Situacao.ABERTO;
    }

    public Chamado(Integer id, Usuario criador, Usuario solicitador, String titulo, String descricao, Categoria categoria, Equipe equipeResponsavel) {
        this.id = id;
        this.criador = criador;
        this.solicitador = solicitador;
        this.titulo = titulo;
        this.descricao = descricao;
        this.categoria = categoria;
        this.equipeResponsavel = equipeResponsavel;
        this.dataDeCriacao = LocalDateTime.now();
        this.dataLimite = LocalDateTime.now();
        this.situacao = Situacao.ABERTO;
    }    

    public void setCriador(Usuario criador) {
        this.criador = criador;
    }

    public void setDataDeCriacao(LocalDateTime dataDeCriacao) {
        this.dataDeCriacao = dataDeCriacao;
    }

    public void setDataLimite(LocalDateTime dataLimite) {
        this.dataLimite = dataLimite;
    }
    
    

    public Usuario getSolicitador() {
        return solicitador;
    }

    public void setSolicitador(Usuario Solicitador) {
        this.solicitador = Solicitador;
    }

    public Atendente getAtendente() {
        return atendente;
    }

    public void setAtendente(Atendente atendente) {
        this.atendente = atendente;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Classificacao getClassificacao() {
        return this.classificacao;
    }

    public void setClassificacao(Classificacao classificacao) {
        this.classificacao = classificacao;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public String getResolucao() {
        return resolucao;
    }

    public void setResolucao(String resolucao) {
        this.resolucao = resolucao;
    }

    public Equipe getEquipeResponsavel() {
        return equipeResponsavel;
    }

    public void setEquipeResponsavel(Equipe equipeResponsavel) {
        this.equipeResponsavel = equipeResponsavel;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Integer getId() {
        return id;
    }

    public Usuario getCriador() {
        return criador;
    }

    public LocalDateTime getDataDeCriacao() {
        return dataDeCriacao;
    }

    public LocalDateTime getDataLimite() {
        return dataLimite;
    }

    @Override
    public int hashCode() {
        Integer hash = 5;
        hash = 29 * hash + this.id;
        hash = 29 * hash + Objects.hashCode(this.criador);
        hash = 29 * hash + Objects.hashCode(this.solicitador);
        hash = 29 * hash + Objects.hashCode(this.titulo);
        hash = 29 * hash + Objects.hashCode(this.descricao);
        hash = 29 * hash + Objects.hashCode(this.dataDeCriacao);
        hash = 29 * hash + Objects.hashCode(this.dataLimite);
        hash = 29 * hash + Objects.hashCode(this.situacao);
        hash = 29 * hash + Objects.hashCode(this.categoria);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Chamado other = (Chamado) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.criador, other.criador)) {
            return false;
        }
        if (!Objects.equals(this.solicitador, other.solicitador)) {
            return false;
        }
        if (!Objects.equals(this.dataDeCriacao, other.dataDeCriacao)) {
            return false;
        }
        if (!Objects.equals(this.dataLimite, other.dataLimite)) {
            return false;
        }
        if (this.situacao != other.situacao) {
            return false;
        }
        if (this.categoria != other.categoria) {
            return false;
        }
        return true;
    }
    
    
}
