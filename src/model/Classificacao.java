/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Pichau
 */
public enum Classificacao {
    PESSIMO(1), RUIM(2), MEDIANO(3), BOM(4), OTIMO(5);

    private final Integer classificacao;

    private Classificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public Integer getClassificacao() {
        return classificacao;
    }
    
    @Override
    public String toString() {
        return classificacao.toString();
    }
}
