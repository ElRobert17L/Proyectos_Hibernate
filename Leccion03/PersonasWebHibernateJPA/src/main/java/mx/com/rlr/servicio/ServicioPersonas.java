package mx.com.rlr.servicio;

import java.util.List;
import mx.com.rlr.dao.PersonaDAO;
import mx.com.rlr.domain.Persona;

public class ServicioPersonas {
    
    private PersonaDAO personaDao;
    
    public ServicioPersonas() {
        this.personaDao = new PersonaDAO();
    }
    
    public List<Persona> listarPersonas() {
        return this.personaDao.listar();
    }
}
