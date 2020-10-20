package mx.com.rlr.servicio;

import java.util.List;
import mx.com.rlr.dao.AlumnoDAO;
import mx.com.rlr.domain.Alumno;

public class ServicioAlumnos {
    
     private AlumnoDAO alumnoDao = new AlumnoDAO();;
    
    public List<Alumno> listarPersonas() {
        return this.alumnoDao.listar();
    }
    
    public void guardarAlumno(Alumno alumno) {
        if (alumno != null && alumno.getIdAlumno() == null) {
            alumnoDao.insertar(alumno);
        } else {
            alumnoDao.modificar(alumno);
        }
    }
    
    public void eliminarAlumno(Alumno alumno) {
        alumnoDao.eliminar(alumno);
    }
    
    public Alumno encontrarAlumno(Alumno alumno) {
        return alumnoDao.buscarAlumnoPorId(alumno);
    }
    
}
