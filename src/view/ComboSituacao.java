/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JComboBox;
import model.Situacao;

/**
 *
 * @author Pichau
 */
public class ComboSituacao extends JComboBox<Situacao>{

    public ComboSituacao() {
        Situacao[] situacoes = Situacao.values();
        for (Situacao situacao : situacoes) {
            this.addItem(situacao);
        }
    }
    
}
