/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ChamadoJpa;
import java.time.LocalDateTime;
import java.util.List;
import model.Atendente;
import model.Chamado;
import model.Situacao;
import model.Usuario;

/**
 *
 * @author Pichau
 */
public class ChamadoController {

    // implementacao do padrao Singleton
    private static ChamadoController instance;
    
    private ChamadoController() {
    }
    
    public static ChamadoController getInstance() {
        if (instance == null) {
            instance = new ChamadoController();
        }
        return instance;
    }
    // fim implementacao do padrao Singleton
    
    private final ChamadoJpa dao = ChamadoJpa.getInstance();
    
    public Chamado novoChamado(Usuario criador) {
        Chamado chamado = new Chamado();
        chamado.setCriador(criador);
        chamado.setDataDeCriacao(LocalDateTime.now());
        chamado.setDataLimite(LocalDateTime.now().plusDays(4));
        return chamado;
    }
    
    public void saveChamado(Chamado chamado) {
        boolean ehNovo = chamado.getId() == null;
        if (ehNovo) {
            dao.incluir(chamado);
        } else {
            dao.atualizar(chamado);
        }
    }
    
    public List<Chamado> getAllChamado() {
        return dao.getAllEntidades();
    }
    
    public List<Chamado> getChamadosNaoAtendidos() {
        return dao.getNaoAtendido();
    }
    
    public List<Chamado> getChamados(Atendente atendendente) {
        return dao.getByAtendente(atendendente);
    }
    
    public List<Chamado> getChamadosBySolicitante(Usuario Solicitante) {
        return dao.getBySolicitante(Solicitante);
    }
    
    public List<Chamado> getChamadosBySituacao(Situacao situacao) {
        return dao.getBySituacao(situacao);
    }
   
    public void deleteChamado(Chamado chamado) {
        dao.excluir(chamado);
    }

    public void expiraChamado() {
        List<Chamado> verificaExpira = this.getChamadosBySituacao(Situacao.ABERTO);
        verificaExpira.forEach((chamado) -> {
            boolean expirado = chamado.getDataLimite().isAfter(LocalDateTime.now());
            if (expirado) {
                chamado.setSituacao(Situacao.EXPIRADO);
            }
        });
    }
}
