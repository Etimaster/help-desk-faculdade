/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import model.Usuario;

/**
 *
 * @author Pichau
 */
public class UsuariosTableModel implements TableModel{
    
    private List<Usuario> usuarios;

    public UsuariosTableModel(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setAtendentes(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public int getRowCount() {
        return usuarios.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch(columnIndex){
            case 0: return "ID";
            case 1: return "Nome";
            case 2: return "E-mail";
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch(columnIndex){
            case 0: return Integer.class;
            case 1: return String.class;
            case 2: return String.class;
        }
        return void.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usuario usuariosRow = usuarios.get(rowIndex);
         switch(columnIndex){
            case 0: return usuariosRow.getId();
            case 1: return usuariosRow.getNome();
            case 2: return usuariosRow.getEmail();
        }
        return null;
    }
    
    public Usuario getUsuarioByIndex(int index){
        return usuarios.get(index);
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
