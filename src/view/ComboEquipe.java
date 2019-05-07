/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.EquipeController;
import java.util.List;
import javax.swing.JComboBox;
import model.Equipe;

/**
 *
 * @author Pichau
 */
public class ComboEquipe extends JComboBox<Equipe>{
    private static final EquipeController EQUIPE_CONTROLLER = EquipeController.getInstance();

    public ComboEquipe() {
        List<Equipe> equipes = EQUIPE_CONTROLLER.getAllEquipe();
        equipes.forEach((equipe) -> {
            this.addItem(equipe);
        });
    }
    
    public void resetCombo(){
        this.removeAllItems();
        List<Equipe> equipes = EQUIPE_CONTROLLER.getAllEquipe();
        equipes.forEach((equipe) -> {
            this.addItem(equipe);
        });
    }
    
}
