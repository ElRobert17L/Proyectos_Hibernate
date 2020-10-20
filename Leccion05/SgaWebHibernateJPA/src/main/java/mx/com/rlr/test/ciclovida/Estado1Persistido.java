package mx.com.rlr.test.ciclovida;

import javax.persistence.*;
import mx.com.rlr.domain.Contacto;

public class Estado1Persistido {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();
        
        //1. ESTADO TRANSITIVO
        Contacto contacto = new Contacto();
        contacto.setEmail("clara@mail.com");
        contacto.setTelefono("5521884745");
        
        //2. PERSISTIMOS EL OBJETO
        em.getTransaction().begin();
        
        em.persist(contacto);
        //em.flush(); <- Es igual a hacer la transaccion pero no hace commit
        
        em.getTransaction().commit();
        
        //3. DETACHED (SEPARADO)
        System.out.println("contacto = " + contacto);
    }
}
