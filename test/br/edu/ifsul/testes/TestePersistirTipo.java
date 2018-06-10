/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Tipo;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author V_M_FT
 */
public class TestePersistirTipo {

    EntityManagerFactory emf;
    EntityManager em;

    public TestePersistirTipo() {
    }

    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("TRABALHO-FINAL-TA-2018-1-6N1PU");
        em = emf.createEntityManager();
    }

    @After
    public void tearDown() {
        em.close();
        emf.close();
    }
    
     @Test
    public void teste() {
        boolean exception = false;
        try { 
            Tipo p1 = new Tipo();
            p1.setTitulo("CHEFE");
            p1.setPrevilegio("Usuario que pode controlar");
            Tipo p2 = new Tipo();
            p2.setTitulo("COMUM");
            p2.setPrevilegio("Usuario comum");
            em.getTransaction().begin();
            em.persist(p1);
            em.persist(p2);
            em.getTransaction().commit();

             } catch (Exception e) {
            e.printStackTrace();
            exception = true;            
        }
     
        Assert.assertEquals(false, exception);
    }
    
}