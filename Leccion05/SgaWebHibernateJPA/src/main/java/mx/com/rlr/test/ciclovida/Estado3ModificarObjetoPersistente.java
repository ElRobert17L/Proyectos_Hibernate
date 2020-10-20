package mx.com.rlr.test.ciclovida;

import javax.persistence.*;
import mx.com.rlr.domain.Contacto;

public class Estado3ModificarObjetoPersistente {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();
        
        //DEEFINIMOS LA VARIABLE
        Contacto contacto = null;
        
        //RECUPERAMOS EL OBJETO DE LA BASE DE DATOS
        //1. ESTADO TRANSITIVO
        contacto = em.find(Contacto.class, 3); //3 es el ID
        
        //2. MODIFICAMOS EL OBJETO
        contacto.setEmail("clara@gmail.com");

        em.getTransaction().begin();
        
        //2. PERSISTIMOS EL OBJETO (Se utliliza merge cuando sea de editar, PERSIST se utliza si es creado el objeto)
        em.merge(contacto);
        
        em.getTransaction().commit();
        
        //3. DETACHED
        System.out.println("contacto = " + contacto);
    }
}
