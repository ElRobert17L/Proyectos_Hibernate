package mx.com.rlr.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import mx.com.rlr.domain.Alumno;
import mx.com.rlr.servicio.ServicioAlumnos;

@WebServlet("/ServletModificar")
public class ServletModificar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String idAlumnS = request.getParameter("idAlumno");
        Integer idAlumno = Integer.parseInt(idAlumnS);

        Alumno alumno = new Alumno();
        alumno.setIdAlumno(idAlumno);

        ServicioAlumnos servicioAlumnos = new ServicioAlumnos();
        alumno = servicioAlumnos.encontrarAlumno(alumno);

        //request.setAttribute("alumno", alumno);
        HttpSession session = request.getSession();
        session.setAttribute("alumno", alumno);

        request.getRequestDispatcher("/WEB-INF/modificarAlumno.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServicioAlumnos servicioAlumnos = new ServicioAlumnos();
        
        String modificar = request.getParameter("Modificar");

        if (modificar != null) {
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String calle = request.getParameter("calle");
            String noCalle = request.getParameter("noCalle");
            String pais = request.getParameter("pais");
            String email = request.getParameter("email");
            String telefono = request.getParameter("telefono");

            HttpSession session = request.getSession();
            Alumno alumno = (Alumno) session.getAttribute("alumno");

            alumno.setNombre(nombre);
            alumno.setApellido(apellido);
            alumno.getDomicilio().setCalle(calle);
            alumno.getDomicilio().setNoCalle(noCalle);
            alumno.getDomicilio().setPais(pais);
            alumno.getContacto().setEmail(email);
            alumno.getContacto().setTelefono(telefono);

            servicioAlumnos.guardarAlumno(alumno);

            session.removeAttribute("alumno");
        } else {
            //CASO ELIMINAR
            String idAlumnoS = request.getParameter("idAlumno");
            Integer idAlumno = Integer.parseInt(idAlumnoS);
            Alumno alumno = new Alumno(idAlumno);
            
            servicioAlumnos.eliminarAlumno(alumno);
        }

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
