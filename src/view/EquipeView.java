/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.EquipeController;
import controller.UsuarioController;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import model.Atendente;
import model.Equipe;

/**
 *
 * @author Pichau
 */
public class EquipeView extends javax.swing.JPanel {

    private Equipe equipe;
    private static final EquipeController EQUIPE_CONTROLLER = EquipeController.getInstance();
    private static final UsuarioController USUARIO_CONTROLLER = UsuarioController.getInstance();

    private static EquipeView instance;

    public static EquipeView getInstance() {
        if (instance == null) {
            instance = new EquipeView();
        }
        return instance;
    }

    /**
     * Creates new form ChamadoView
     */
    public EquipeView() {
        initComponents();
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
        txtNomeEquipe.setText(equipe.getNome());
        DefaultListModel listModelEquipe = new DefaultListModel();
        List<Atendente> atendentesEquipe = equipe.getAtendentes();
        if(atendentesEquipe != null){
            atendentesEquipe.forEach((atendente) -> {
                listModelEquipe.addElement(atendente);
            }); 
        }
        listaAtendentesEquipe.setModel(listModelEquipe);
        DefaultListModel listModelOutos = new DefaultListModel();
        List<Atendente> atendentesOutros = USUARIO_CONTROLLER.getAllAtendentes();
        if(atendentesOutros != null){
            atendentesOutros.forEach((atendenteOutro) -> {
                listModelOutos.addElement(atendenteOutro);
            });
        }
        listaAtendentesOutros.setModel(listModelOutos);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        lblInfo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNomeEquipe = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaAtendentesEquipe = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaAtendentesOutros = new javax.swing.JList<>();
        jPanel2 = new javax.swing.JPanel();
        btnDeletar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanel3.add(lblInfo);

        add(jPanel3, java.awt.BorderLayout.NORTH);

        jPanel1.setLayout(new java.awt.GridLayout(3, 1));

        jLabel1.setText("Nome da equipe");
        jPanel1.add(jLabel1);
        jPanel1.add(txtNomeEquipe);

        jLabel2.setText("Atendentes da equipe");
        jPanel1.add(jLabel2);

        jLabel3.setText("Outros atendentes");
        jPanel1.add(jLabel3);

        listaAtendentesEquipe.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaAtendentesEquipe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaAtendentesEquipeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listaAtendentesEquipe);

        jPanel1.add(jScrollPane1);

        listaAtendentesOutros.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaAtendentesOutros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaAtendentesOutrosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(listaAtendentesOutros);

        jPanel1.add(jScrollPane2);

        add(jPanel1, java.awt.BorderLayout.CENTER);

        btnDeletar.setText("Excluir");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });
        jPanel2.add(btnDeletar);

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        jPanel2.add(btnSalvar);

        add(jPanel2, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        if(equipe.getId() == null){
            TelaPrincipal.getInstance().setInfo("Nova equipe não pode ser excluida");
        }else{
            EQUIPE_CONTROLLER.deleteEquipe(equipe);
            TelaPrincipal.getInstance().showPainel(TelaPrincipal.PAINEL_EQUIPES);
            TelaPrincipal.getInstance().setInfo("Equipe excluida com sucesso");
        }
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void listaAtendentesOutrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaAtendentesOutrosMouseClicked
        if (evt.getClickCount() == 2) {
            switchAtentende(listaAtendentesEquipe,listaAtendentesOutros);
        }
    }//GEN-LAST:event_listaAtendentesOutrosMouseClicked

    private void listaAtendentesEquipeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaAtendentesEquipeMouseClicked
        if (evt.getClickCount() == 2) {
            switchAtentende(listaAtendentesOutros,listaAtendentesEquipe);
        }
    }//GEN-LAST:event_listaAtendentesEquipeMouseClicked

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        equipe.setNome(txtNomeEquipe.getText());
        equipe.removeAllAtendentes();
        int size = listaAtendentesEquipe.getModel().getSize();
        if(size != 0){
            for (int i = 0; i < size; i++) {
                Atendente atendente = listaAtendentesEquipe.getModel().getElementAt(i);
                equipe.addAtendente(atendente);
                atendente.setEquipe(equipe);
            }   
        }
        
        EQUIPE_CONTROLLER.saveEquipe(equipe);
        TelaPrincipal.getInstance().showPainel(TelaPrincipal.PAINEL_EQUIPES);
        TelaPrincipal.getInstance().setInfo("Equipe salva com sucesso");
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void switchAtentende(JList in, JList out) {
        DefaultListModel listModelIn = (DefaultListModel) in.getModel();
        DefaultListModel listModelOut = (DefaultListModel) out.getModel();
        if (listModelIn == null) {
            listModelIn = new DefaultListModel();
            listaAtendentesEquipe.setModel(listModelIn);
        }
        listModelIn.addElement(out.getSelectedValue());
        listModelOut.removeElement(out.getSelectedValue());
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JList<Atendente> listaAtendentesEquipe;
    private javax.swing.JList<Atendente> listaAtendentesOutros;
    private javax.swing.JTextField txtNomeEquipe;
    // End of variables declaration//GEN-END:variables
}
