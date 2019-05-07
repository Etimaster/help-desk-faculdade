/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.EquipeJpa;
import java.util.List;
import model.Atendente;
import model.Equipe;

/**
 *
 * @author Pichau
 */
public class EquipeController {
    // implementacao do padrao Singleton
    private static EquipeController instance;

    private EquipeController() {
    }

    public static EquipeController getInstance() {
        if (instance == null) {
            instance = new EquipeController();
        }
        return instance;
    }
    // fim implementacao do padrao Singleton
    
    private final EquipeJpa dao = EquipeJpa.getInstance();
    
    public Equipe novoEquipe() {
        Equipe chamado = new Equipe();
        return chamado;
    }
    
    public void saveEquipe(Equipe equipe){
        boolean ehNovo = equipe.getId() == null;
        if(ehNovo){
            dao.incluir(equipe);
        }else{
            dao.atualizar(equipe);
        }
    }
    
    public List<Equipe> getAllEquipe(){
        return dao.getAllEntidades();
    }
    
    public List<Atendente> getAllAtendentesFromAtendente(Atendente atendente){
        return dao.getAllEntidades(atendente).getAtendentes();
    }
    
    public void updateEquipe(Equipe chamado){
        dao.atualizar(chamado);
    }
    
    public void deleteEquipe(Equipe chamado){
        dao.excluir(chamado);
    }
}
