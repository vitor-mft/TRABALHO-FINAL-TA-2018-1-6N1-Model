/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Pessoas;
import br.edu.ifsul.modelo.Genero;
import br.edu.ifsul.modelo.Livros;
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
public class TestePersistirPessoas {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirPessoas() {
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
    public void teste(){
        boolean exception = false;
        try {
            Pessoas p = new Pessoas();
            p.setApelido("vitor");
            p.setCpf("00601469070");
            p.setSenha("54321");
            
            Tipo t = em.find(Tipo.class, "CHEFE");
           
            p.getTipo().add(t);
           
                       
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        } catch (Exception e){
            exception = true;
            e.printStackTrace();
        }
      
        Assert.assertEquals(false, exception);
    }
    
}
