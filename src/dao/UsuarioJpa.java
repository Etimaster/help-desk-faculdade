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
import model.Usuario;

/**
 *
 * @author Pichau
 */
public class UsuarioJpa implements Dao<Usuario> {

    // implementacao do padrao Singleton
    private static UsuarioJpa instance;

    private UsuarioJpa(EntityManager em) {
        this.em = em;
    }

    public static UsuarioJpa getInstance() {
        if (instance == null) {
            instance = new UsuarioJpa(JpaUtil.getEntityManager());
        }
        return instance;
    }
    // fim implementacao do padrao Singleton

    private final EntityManager em;

    @Override
    public void incluir(Usuario entidade) {
        try {
            em.getTransaction().begin();
            em.persist(entidade);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public void atualizar(Usuario entidade) {
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
    public void excluir(Usuario entidade) {
        try {
            em.getTransaction().begin();
            em.remove(entidade);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public Usuario getEntidadeById(Integer id) {
        return em.find(Usuario.class, id);
    }

    @Override
    public List<Usuario> getAllEntidades() {
        TypedQuery<Usuario> query = em.createNamedQuery("Usuario.getAll", Usuario.class);
        return query.getResultList();
    }
    
    public List<Atendente> getAllAtendentes() {
        TypedQuery<Atendente> query = em.createNamedQuery("Atendente.getAll", Atendente.class);
        return query.getResultList();
    }
    
    public Usuario getByEmail(String email) {
        TypedQuery<Usuario> query = em.createNamedQuery("Usuario.getEmail", Usuario.class);
        query.setParameter("%email%", email);
        return query.getSingleResult();
    }
    
    public Usuario login(String email, String senha) throws javax.persistence.NoResultException{
        TypedQuery<Usuario> query = em.createNamedQuery("Usuario.getLogin", Usuario.class);
        query.setParameter("email", email);
        query.setParameter("senha", senha);
        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
