package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

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
    @NamedQuery(name = "Atendente.getAll", query = "select a from Atendente a")
})
public class Atendente extends Usuario implements Serializable{
    @ManyToOne
    private Equipe equipe;
    private Integer classificacao;
    private Integer chamadosResolvidos;

    public Atendente() {
    }

    public Atendente(Equipe equipe, Integer classificacao, Integer chamadosResolvidos, Integer id, String cpf, String nome, String senha, String email) {
        super(id, cpf, nome, senha, email);
        this.equipe = equipe;
        this.classificacao = classificacao;
        this.chamadosResolvidos = chamadosResolvidos;
    }

    public Equipe getEquipe() {
        return equipe;
    }
    
    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public Integer getChamadosResolvidos() {
        return chamadosResolvidos;
    }

    public void resolveChamado() {
        this.chamadosResolvidos++;
    }

    public Integer getClassificacao() {
        return classificacao;
    }
    
    public void classifica(Classificacao classificacao){
       this. classificacao = (this.classificacao *  this.getChamadosResolvidos() + classificacao.getClassificacao())/5;
       this.resolveChamado();
    }
}
