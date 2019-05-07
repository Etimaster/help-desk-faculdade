/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.UsuarioController;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Atendente;
import model.Equipe;
import model.Usuario;

/**
 *
 * @author Pichau
 */
public class UsuarioView extends javax.swing.JPanel {
    private static final UsuarioController USUARIO_CONTROLLER = UsuarioController.getInstance();
    private Usuario usuario;
    private Atendente atendente;
    
    private static UsuarioView instance;

    public static UsuarioView getInstance() {
        if(instance==null){
            instance = new UsuarioView();
        }
        return instance;
    }
    
    /**
     * Creates new form UsuariaView
     */
    public UsuarioView() {
        initComponents();
    }
    
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
        ehAtendente();
        txtNome.setText(usuario.getNome());
        txtCpf.setText(usuario.getCpf());
        txtEmail.setText(usuario.getEmail());
        
        if (ehAtendente()) {
            atendente = (Atendente) usuario;
            lblEquipe.setEnabled(true);
            comboEquipe.setEnabled(true);
            comboEquipe.setSelectedItem(atendente.getEquipe());
            resetCombo();
            panelChamadosResolvidos.setEnabled(true);
            panelClassificacao.setEnabled(true);
            Integer numChamadosResolvidos =  atendente.getChamadosResolvidos();
            if(numChamadosResolvidos != null){
                lblNumChamadosResolvidos.setText(numChamadosResolvidos.toString());
            }
            Integer numClassificacao = atendente.getClassificacao();
            if(numChamadosResolvidos != null){
                lblNumClassificacao.setText(numClassificacao.toString());
            }
        }
    }
    
    public boolean ehAtendente(){
        return usuario instanceof Atendente;
    }
    
    private void resetCombo(){
        ComboEquipe comboReset = (ComboEquipe) comboEquipe;
        comboReset.resetCombo();
        comboEquipe = comboReset;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblCpf = new javax.swing.JLabel();
        txtCpf = new javax.swing.JTextField();
        lblSenha = new javax.swing.JLabel();
        passSenha = new javax.swing.JPasswordField();
        lblConfimaSenha = new javax.swing.JLabel();
        passConfirm = new javax.swing.JPasswordField();
        lblEquipe = new javax.swing.JLabel();
        comboEquipe = new view.ComboEquipe();
        panelChamadosResolvidos = new javax.swing.JPanel();
        lblchamadosResolvidos = new javax.swing.JLabel();
        lblNumChamadosResolvidos = new javax.swing.JLabel();
        panelClassificacao = new javax.swing.JPanel();
        lblCassificacao = new javax.swing.JLabel();
        lblNumClassificacao = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnDeletar = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.GridLayout(7, 2));

        lblNome.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblNome.setText("Nome");
        jPanel1.add(lblNome);
        lblNome.getAccessibleContext().setAccessibleName("Nome do úsuário");

        jPanel1.add(txtNome);

        lblEmail.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblEmail.setText("E-mail");
        jPanel1.add(lblEmail);
        jPanel1.add(txtEmail);

        lblCpf.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblCpf.setText("CPF");
        jPanel1.add(lblCpf);
        lblCpf.getAccessibleContext().setAccessibleName("CPF do usuário");

        jPanel1.add(txtCpf);

        lblSenha.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblSenha.setText("Senha");
        jPanel1.add(lblSenha);
        lblSenha.getAccessibleContext().setAccessibleName("Senha do usuário");

        passSenha.setMargin(new java.awt.Insets(3, 3, 3, 3));
        jPanel1.add(passSenha);

        lblConfimaSenha.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblConfimaSenha.setText("Confirmar senha");
        jPanel1.add(lblConfimaSenha);
        lblConfimaSenha.getAccessibleContext().setAccessibleName("Confirmar senha do usuário");
        lblConfimaSenha.getAccessibleContext().setAccessibleDescription("");

        passConfirm.setMargin(new java.awt.Insets(3, 3, 3, 3));
        jPanel1.add(passConfirm);

        lblEquipe.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblEquipe.setText("Equipe");
        lblEquipe.setEnabled(false);
        jPanel1.add(lblEquipe);

        comboEquipe.setEnabled(false);
        jPanel1.add(comboEquipe);

        panelChamadosResolvidos.setEnabled(false);

        lblchamadosResolvidos.setText("Chamados Resolvidos:");
        panelChamadosResolvidos.add(lblchamadosResolvidos);
        panelChamadosResolvidos.add(lblNumChamadosResolvidos);

        jPanel1.add(panelChamadosResolvidos);

        panelClassificacao.setEnabled(false);

        lblCassificacao.setText("Cassificação:");
        panelClassificacao.add(lblCassificacao);
        panelClassificacao.add(lblNumClassificacao);

        jPanel1.add(panelClassificacao);

        add(jPanel1, java.awt.BorderLayout.CENTER);

        btnDeletar.setText("Excluir");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });
        jPanel2.add(btnDeletar);

        btnSave.setText("Salvar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel2.add(btnSave);
        btnSave.getAccessibleContext().setAccessibleName("Botão Salvar");

        add(jPanel2, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if(passSenha.getText().equals(passConfirm.getText())){
            usuario.setNome(txtNome.getText());
            usuario.setEmail(txtEmail.getText());
            usuario.setCpf(txtCpf.getText());
            if (!"".equals(passSenha.getText())) {
                usuario.setSenha(passSenha.getText());
                try {
                    usuario.criptografaSenha();
                } catch (UnsupportedEncodingException ex) {
                    TelaPrincipal.getInstance().setInfo("Não foi possivel salvar usuario");
                }
            }
            if (ehAtendente()) {
                atendente = (Atendente) usuario;
                atendente.setEquipe((Equipe) comboEquipe.getSelectedItem());
                USUARIO_CONTROLLER.saveUsuario(atendente);
            }else{
                USUARIO_CONTROLLER.saveUsuario(usuario);
            }
            TelaPrincipal.getInstance().showPainel(TelaPrincipal.PAINEL_USUARIOS);
            TelaPrincipal.getInstance().setInfo("Usuario salvo com sucesso");
            
        }else{
            TelaPrincipal.getInstance().setInfo("As senhas não são iguais");
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        if(usuario.getId() == null){
            TelaPrincipal.getInstance().setInfo("Usuario novo não pode ser excluido");
        }else{
            USUARIO_CONTROLLER.deleteUsuario(usuario);
            TelaPrincipal.getInstance().showPainel(TelaPrincipal.PAINEL_USUARIOS);
            TelaPrincipal.getInstance().setInfo("Usuario excluida com sucesso");
        }
    }//GEN-LAST:event_btnDeletarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<Equipe> comboEquipe;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblCassificacao;
    private javax.swing.JLabel lblConfimaSenha;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEquipe;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNumChamadosResolvidos;
    private javax.swing.JLabel lblNumClassificacao;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblchamadosResolvidos;
    private javax.swing.JPanel panelChamadosResolvidos;
    private javax.swing.JPanel panelClassificacao;
    private javax.swing.JPasswordField passConfirm;
    private javax.swing.JPasswordField passSenha;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
