/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;


import br.edu.ifsul.modelo.Autores;
import br.edu.ifsul.modelo.Genero;
import br.edu.ifsul.modelo.Livros;
import br.edu.ifsul.modelo.Pessoas;
import com.sun.security.ntlm.Client;
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
public class TestePersistirLivros {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirLivros() {
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
            Livros l = new Livros();
            l.setNome("Quase la");
            l.setEdicao("edicao001");
            l.setDisponivel(true);
            l.setAutores(em.find(Autores.class,1));
            l.setPessoas(em.find(Pessoas.class, 6));                  
            
            em.getTransaction().begin();
            em.persist(l);
            em.getTransaction().commit();
        } catch (Exception e){
            exception = true;
            e.printStackTrace();
        }
      
        Assert.assertEquals(false, exception);
    }
    
}
