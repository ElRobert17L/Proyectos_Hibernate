package mx.com.rlr.dao;

import java.util.List;
import javax.persistence.Query;
import mx.com.rlr.domain.Asignacion;

public class AsignacionDAO extends GenericDAO {
    
    public List<Asignacion> listar() {
        String consulta = "SELECT a FROM Asignacion a";
        em = getEntityManager();
        Query query = em.createQuery(consulta);
        return query.getResultList();
    }

    public void insertar(Asignacion asignacion) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(asignacion);
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

    public void modificar(Asignacion asignacion) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(asignacion);
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

    public void eliminar(Asignacion asignacion) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(asignacion));
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

    public Asignacion buscarAlumnoPorId(Asignacion a) {
        return em.find(Asignacion.class, a.getIdAsignacion());
    }
}
