/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ChamadoController;
import java.util.List;
import model.Chamado;
import model.Situacao;

/**
 *
 * @author Pichau
 */
public class ChamadosView extends javax.swing.JPanel {
    private static final ChamadoController CHAMADO_CONTROLLER = ChamadoController.getInstance();
    
    private static ChamadosView instance;

    public static ChamadosView getInstance(List<Chamado> chamados) {
        if(instance==null){
            instance = new ChamadosView(chamados);
        }
        return instance;
    }
    
    private ChamadosTableModel chamadosTableModel;
    
    public ChamadosView(List<Chamado> chamados) {
        this.chamadosTableModel = new ChamadosTableModel(chamados);
        initComponents();
    }
    
    void setChamados(List<Chamado> chamados){
        ChamadosTableModel atualiza = new ChamadosTableModel(chamados);
        this.tableChamados.setModel(atualiza);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        comboSituacao = new view.ComboSituacao();
        btnPesquisa = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableChamados = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jPanel2.add(comboSituacao);

        btnPesquisa.setText("Pesquisar");
        btnPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaActionPerformed(evt);
            }
        });
        jPanel2.add(btnPesquisa);

        add(jPanel2, java.awt.BorderLayout.NORTH);

        tableChamados.setModel(this.chamadosTableModel);
        tableChamados.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableChamados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableChamadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableChamados);

        jPanel1.add(jScrollPane1);

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaActionPerformed
        Situacao situacao = (Situacao) comboSituacao.getSelectedItem();
        this.setChamados(CHAMADO_CONTROLLER.getChamadosBySituacao(situacao));
    }//GEN-LAST:event_btnPesquisaActionPerformed

    private void tableChamadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableChamadosMouseClicked
        if(evt.getClickCount()==2){
            int selectedRow = tableChamados.getSelectedRow();
            ChamadosTableModel model = (ChamadosTableModel) tableChamados.getModel();
            Chamado chamadoByIndex = model.getChamadoByIndex(selectedRow);
            ChamadoView.getInstance().setChamado(chamadoByIndex);
            TelaPrincipal.getInstance().showPainel(TelaPrincipal.PAINEL_CHAMADO);
        }
    }//GEN-LAST:event_tableChamadosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPesquisa;
    private javax.swing.JComboBox<Situacao> comboSituacao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableChamados;
    // End of variables declaration//GEN-END:variables
}