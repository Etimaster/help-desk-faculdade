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
public enum Situacao {
    ABERTO("Aberto"), EM_ATENDIMENTO("Em atendimento"), CONCLUIDO("Concluído"), EXPIRADO("Expirado");
    
    private final String descricao;

    private Situacao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
    
    
    
    
}
