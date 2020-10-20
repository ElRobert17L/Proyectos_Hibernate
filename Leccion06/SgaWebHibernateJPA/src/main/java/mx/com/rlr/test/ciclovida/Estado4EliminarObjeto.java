package mx.com.rlr.test.ciclovida;

import javax.persistence.*;
import mx.com.rlr.domain.Contacto;

public class Estado4EliminarObjeto {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();

        //DEEFINIMOS LA VARIABLE
        Contacto contacto = null;

        //RECUPERAMOS EL OBJETO DE LA BASE DE DATOS
        //1. ESTADO TRANSITIVO
        contacto = em.find(Contacto.class, 3); //3 es el ID

        em.getTransaction().begin();

        //2. REMOVE
        em.remove(em.merge(contacto));

        em.getTransaction().commit();

        //3. ESTADO TRANSITIVO
        System.out.println("contacto = " + contacto);
    }
}
