package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

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
    @NamedQuery(name = "Equipe.getAll", query = "select e from Equipe e")
    ,
    @NamedQuery(name = "Equipe.getByAtendente", query = "select e from Equipe e where :atendente member of e.atendentes")
})
public class Equipe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @OneToMany
    private List<Atendente> atendentes;

    public Equipe() {
        atendentes = new ArrayList<>();
    }

    public Equipe(Integer id, String nome, List<Atendente> atendentes) {
        this.id = id;
        this.nome = nome;
        this.atendentes = atendentes;
    }
    
    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Atendente> getAtendentes() {
        return atendentes;
    }

    public void setAtendentes(List<Atendente> atendentes) {
        this.atendentes = atendentes;
    }

    public void addAtendente(Atendente atendente) {
        atendente.setEquipe(this);
        this.atendentes.add(atendente);
    }
    
    public void removeAllAtendentes(){
        if(!atendentes.isEmpty()){
            atendentes.clear();
        }
    }

    @Override
    public String toString() {
        return  nome;
    }
    
    @Override
    public int hashCode() {
        Integer hash = 5;
        hash = 47 * hash + this.id;
        hash = 47 * hash + Objects.hashCode(this.nome);
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
        final Equipe other = (Equipe) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }
}
