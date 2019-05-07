/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UsuarioJpa;
import java.util.ArrayList;
import java.util.List;
import model.Atendente;
import model.Usuario;

/**
 *
 * @author Pichau
 */
public class UsuarioController {
    // implementacao do padrao Singleton
    private static UsuarioController instance;

    private UsuarioController() {
    }

    public static UsuarioController getInstance() {
        if (instance == null) {
            instance = new UsuarioController();
        }
        return instance;
    }
    // fim implementacao do padrao Singleton

    
    private final UsuarioJpa dao = UsuarioJpa.getInstance();
    
    public Usuario novoUsuario() {
        Usuario usuario = new Usuario();
        return usuario;
    }
    
    public Atendente novoAtendente() {
        Atendente atendente = new Atendente();
        return atendente;
    }
    
    public void saveUsuario(Usuario usuario){
        dao.incluir(usuario);
    }
    
    public List<Usuario> getAllUsuarios(){
        List<Usuario> usuarios =  new ArrayList<>();
        usuarios.add(new Usuario(1, "123", "marcelo", "", "m@c"));
        usuarios.add(new Usuario(1, "123", "dami", "", "m@c"));
        usuarios.add(new Usuario(1, "123", "sdgsdg", "", "asfd@asf"));
        usuarios.add(new Usuario(1, "123", "tuykh", "dfsf", "m@c"));
        usuarios.add(new Usuario(1, "123", "fgj", "", "m@c"));
        //return usuarios;
        return dao.getAllEntidades();
    }
    
    public List<Atendente> getAllAtendentes(){
        return dao.getAllAtendentes();
    }
    
    public Usuario getUsuariosByEmail(String email){
        return dao.getByEmail(email);
    }
    
    public Usuario login(String email, String senha){
        return dao.login(email, senha);
    }
    
    public void updateUsuario(Usuario usuario){
        dao.atualizar(usuario);
    }
    
    public void deleteUsuario(Usuario usuario){
        dao.excluir(usuario);
    }
}
