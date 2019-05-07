/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Pichau
 */
public class JpaUtil {
    private static EntityManager em;
    private static EntityManagerFactory emf;

    public static EntityManager getEntityManager() {
        if (em == null) {
            emf = Persistence.createEntityManagerFactory("HelpdeskPU");
            em = emf.createEntityManager();
        }
        return em;
    }
    
    public static void close(){
        em.close();
        emf.close();
    }
    
}
