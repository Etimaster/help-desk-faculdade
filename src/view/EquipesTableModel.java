/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import model.Equipe;

/**
 *
 * @author Pichau
 */
public class EquipesTableModel implements TableModel{
    private List<Equipe> equipes;

    public EquipesTableModel(List<Equipe> equipes) {
        this.equipes = equipes;
    }

    public List<Equipe> getEquipe() {
        return this.equipes;
    }

    public void setAtendentes(List<Equipe> equipes) {
        this.equipes = equipes;
    }

    @Override
    public int getRowCount() {
        return equipes.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch(columnIndex){
            case 0: return "Nome";
            case 1: return "Qauntidade de Usuarios";
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch(columnIndex){
            case 0: return Integer.class;
            case 1: return Integer.class;
        }
        return void.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Equipe equipeRow = equipes.get(rowIndex);
         switch(columnIndex){
            case 0: return equipeRow.getNome();
            case 1: return equipeRow.getAtendentes().size();
        }
        return null;
    }
    
    public Equipe getEquipeByIndex(int index){
        return equipes.get(index);
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
    }
}
