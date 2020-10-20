package test;

import mx.com.rlr.dao.PersonaDAO;
import mx.com.rlr.domain.Persona;

public class OperacionesHibernateJPA {
    
    public static void main(String[] args) {
        //DB->MOSTRAR TODA LA CONSULTA
        PersonaDAO personaDao = new PersonaDAO();
        personaDao.listar();
        
        //DB->INSERTAR
//        Persona persona = new Persona();
//        persona.setNombre("Carlos");
//        persona.setApellido("Lara");
//        persona.setEmail("clara@mail.com");
//        persona.setTelefono("5511233155");
        
//        personaDao.insertar(persona);
        //personaDao.listar();
        
        //DB->MODIFICAR
        Persona persona = new Persona();
        persona.setIdPersona(3);
        persona = personaDao.buscarPersonaPorId(persona);
        System.out.println("persona encontrada = " + persona);
        
//        persona.setApellido("Esparza");
//        persona.setEmail("cesparza@mail.com");
        
//        personaDao.modificar(persona);
//        personaDao.listar();
        
        //DB->ELIMINAR
        personaDao.eliminar(persona);
        personaDao.listar();
    }
}
