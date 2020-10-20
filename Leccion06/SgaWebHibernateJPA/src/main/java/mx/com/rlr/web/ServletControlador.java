package mx.com.rlr.web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import mx.com.rlr.domain.Alumno;
import mx.com.rlr.servicio.ServicioAlumnos;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet{
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            ServicioAlumnos servicioAlumnos = new ServicioAlumnos();
            
            List<Alumno> alumnos = servicioAlumnos.listarPersonas();
            
            request.setAttribute("alumnos", alumnos);
            
            request.getRequestDispatcher("/WEB-INF/listarAlumnos.jsp").forward(request, response);
        } catch (ServletException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
