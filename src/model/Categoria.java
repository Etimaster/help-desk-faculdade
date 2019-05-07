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
public enum Categoria {
    FALHA("Falha"), REQUISICAO_SERVICOS("Requisição de Serviços"), REQUISICAO_INFORMACAO("Requisição de informação"), NOTIFICACAO_mONITORAMENTO("Notificação de monitoramento");

    private final String descricao;

    private Categoria(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
