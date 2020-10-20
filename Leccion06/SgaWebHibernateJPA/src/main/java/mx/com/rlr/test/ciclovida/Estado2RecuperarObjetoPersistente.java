package mx.com.rlr.test.ciclovida;

import javax.persistence.*;
import mx.com.rlr.domain.Contacto;

public class Estado2RecuperarObjetoPersistente {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();
        
        //DEEFINIMOS LA VARIABLE
        Contacto contacto = null;
        
        //RECUPERAMOS EL OBJETO DE LA BASE DE DATOS
        contacto = em.find(Contacto.class, 3); //3 es el ID
        
        //DETACHED
        System.out.println("contacto = " + contacto);
    }
}
