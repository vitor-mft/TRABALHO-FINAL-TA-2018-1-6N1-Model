package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Autores;
import br.edu.ifsul.modelo.Genero;
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
public class TestePersistirAutores {

    EntityManagerFactory emf;
    EntityManager em;

    public TestePersistirAutores() {

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
    public void testePersistirPais() {
        boolean exception = false;
        try {
            Autores aut = new Autores();
            aut.setNome("sommerville");
            aut.setGenero(em.find(Genero.class, 3));
            em.getTransaction().begin();
            em.persist(aut);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            exception = true;

        }
       Assert.assertEquals(false, exception);
    }

}
