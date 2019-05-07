/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import model.Chamado;

/**
 *
 * @author Pichau
 */
public class ChamadosTableModel implements TableModel{
    private List<Chamado> chamados;

    public ChamadosTableModel(List<Chamado> chamados) {
        this.chamados = chamados;
    }

    public List<Chamado> getChamado() {
        return this.chamados;
    }

    public void setAtendentes(List<Chamado> chamados) {
        this.chamados = chamados;
    }

    @Override
    public int getRowCount() {
        return chamados.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch(columnIndex){
            case 0: return "ID";
            case 1: return "Titulo";
            case 2: return "Situacao";
            case 3: return "Criador";
            case 4: return "Solicitador";
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch(columnIndex){
            case 0: return Integer.class;
            case 1: return String.class;
            case 2: return String.class;
            case 3: return String.class;
            case 4: return String.class;
        }
        return void.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Chamado chamadosRow = chamados.get(rowIndex);
         switch(columnIndex){
            case 0: return chamadosRow.getId();
            case 1: return chamadosRow.getTitulo();
            case 2: return chamadosRow.getSituacao();
            case 3: return chamadosRow.getCriador().getNome();
            case 4: return chamadosRow.getSolicitador().getNome();
        }
        return null;
    }
    
    public Chamado getChamadoByIndex(int index){
        return chamados.get(index);
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
