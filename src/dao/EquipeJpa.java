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
import model.Equipe;

/**
 *
 * @author Pichau
 */
public class EquipeJpa implements Dao<Equipe>{
        // implementacao do padrao Singleton
    private static EquipeJpa instance;

    private EquipeJpa(EntityManager em) {
        this.em = em;
    }

    public static EquipeJpa getInstance() {
        if (instance == null) {
            instance = new EquipeJpa(JpaUtil.getEntityManager());
        }
        return instance;
    }
    // fim implementacao do padrao Singleton

    private final EntityManager em;

    @Override
    public void incluir(Equipe entidade) {
        try {
            em.getTransaction().begin();
            em.persist(entidade);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public void atualizar(Equipe entidade) {
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
    public void excluir(Equipe entidade) {
        try {
            em.getTransaction().begin();
            em.remove(entidade);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public Equipe getEntidadeById(Integer id) {
        return em.find(Equipe.class, id);
    }

    @Override
    public List<Equipe> getAllEntidades() {
        TypedQuery<Equipe> query = em.createNamedQuery("Equipe.getAll", Equipe.class);
        return query.getResultList();
    }
    
    public Equipe getAllEntidades(Atendente atendente) {
        TypedQuery<Equipe> query = em.createNamedQuery("Equipe.getByAtendente", Equipe.class);
        query.setParameter("atendente", atendente);
        return query.getSingleResult();
    }
}
