package mx.com.rlr.dao;

import java.util.List;
import javax.persistence.*;
import mx.com.rlr.domain.Alumno;

public class AlumnoDAO extends GenericDAO{
    
    public List<Alumno> listar() {
        String consulta = "SELECT a FROM Alumno a";
        em = getEntityManager();
        Query query = em.createQuery(consulta);
        return query.getResultList();
    }

    public void insertar(Alumno alumno) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(alumno);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            em.getTransaction().rollback();
        }
//        finally {
//            if (em != null) {
//                em.close();
//            }
//        }
    }

    public void modificar(Alumno alumno) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(alumno);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            em.getTransaction().rollback();
        }
//        finally {
//            if (em != null) {
//                em.close();
//            }
//        }
    }

    public void eliminar(Alumno alumno) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(alumno));
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            em.getTransaction().rollback();
        }
//        finally {
//            if (em != null) {
//                em.close();
//            }
//        }
    }

    public Alumno buscarAlumnoPorId(Alumno a) {
        return em.find(Alumno.class, a.getIdAlumno());
    }
}
