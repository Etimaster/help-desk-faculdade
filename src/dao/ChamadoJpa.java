/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.Atendente;
import model.Chamado;
import model.Situacao;
import model.Usuario;

/**
 *
 * @author Pichau
 */
public class ChamadoJpa implements Dao<Chamado>{
    
    // implementacao do padrao Singleton
    private static ChamadoJpa instance;

    private ChamadoJpa(EntityManager em) {
        this.em = em;
    }

    public static ChamadoJpa getInstance() {
        if (instance == null) {
            instance = new ChamadoJpa(JpaUtil.getEntityManager());
        }
        return instance;
    }
    // fim implementacao do padrao Singleton

    private final EntityManager em;

    @Override
    public void incluir(Chamado entidade) {
        try {
            em.getTransaction().begin();
            em.persist(entidade);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public void atualizar(Chamado entidade) {
        try {
            em.getTransaction().begin();
            if (!em.contains(entidade)) {
                em.merge(entidade);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public void excluir(Chamado entidade) {
        try {
            em.getTransaction().begin();
            em.remove(entidade);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public Chamado getEntidadeById(Integer id) {
        return em.find(Chamado.class, id);
    }

    @Override
    public List<Chamado> getAllEntidades() {
        TypedQuery<Chamado> query = em.createNamedQuery("Chamado.getAll", Chamado.class);
        return query.getResultList();
    }
    
    public List<Chamado> getByAtendente(Atendente atendente) {
        TypedQuery<Chamado> query = em.createNamedQuery("Chamado.atendente", Chamado.class);
        query.setParameter("atendente", atendente);
        return query.getResultList();
    }
    
    public List<Chamado> getNaoAtendido() {
        TypedQuery<Chamado> query = em.createNamedQuery("Chamado.naoAtendidos", Chamado.class);
        return query.getResultList();
    }
    
    public List<Chamado> getBySolicitante(Usuario solicitante) {
        TypedQuery<Chamado> query = em.createNamedQuery("Chamado.solicitador", Chamado.class);
        query.setParameter("solicitador", solicitante);
        return query.getResultList();
    }
    
    public List<Chamado> getBySituacao(Situacao situacao) {
        TypedQuery<Chamado> query = em.createNamedQuery("Chamado.getBySituacao", Chamado.class);
        query.setParameter("situacao", situacao);
        return query.getResultList();
    }
}
