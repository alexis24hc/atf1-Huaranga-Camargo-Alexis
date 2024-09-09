package proyecto.controller;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import proyecto.dao.AsignaturaDao;
import proyecto.model.Asignatura;

@WebServlet("/cursoController")
public class CursoController extends HttpServlet {
    private static final String LISTAR_ASIGNATURAS = "/listaAsignatura.jsp";
    private static final String INSERTAR = "/nuevaAsignatura.jsp";
    private static final String ACTUALIZAR = "/actualizarAsignatura.jsp";
    private AsignaturaDao asignaturaDao;

    public CursoController() {
        super();
        asignaturaDao = new AsignaturaDao(); // Instanciamos el DAO
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String redireccion = "";
        String accion = request.getParameter("accion");

        if (accion.equalsIgnoreCase("listar")) {
            redireccion = LISTAR_ASIGNATURAS;
            HttpSession sesion = request.getSession();
            sesion.setAttribute("asignaturas", asignaturaDao.buscarTodos());
        } else if (accion.equalsIgnoreCase("insertar")) {
            redireccion = INSERTAR;
        } else if (accion.equalsIgnoreCase("eliminar")) {
            // Capturar el código del objeto a eliminar
            String codigo = request.getParameter("codigo");
            // Hacer uso del método dar baja
            asignaturaDao.darBaja(codigo);
            redireccion = LISTAR_ASIGNATURAS;
            HttpSession sesion = request.getSession();
            sesion.setAttribute("asignaturas", asignaturaDao.buscarTodos());
        } else if (accion.equalsIgnoreCase("editar")) {
            String codigo = request.getParameter("codigo");
            // Hacer uso del método buscarPorCodigo
            Asignatura asig = asignaturaDao.buscarPorCodigo(codigo);
            HttpSession sesion = request.getSession();
            sesion.setAttribute("asignatura", asig);
            redireccion = ACTUALIZAR;
        }
        
        // La vista permite asociar una redirección
        RequestDispatcher vista = request.getRequestDispatcher(redireccion);
        vista.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        // Crear una instancia de la clase Asignatura
        Asignatura asig = new Asignatura();
        asig.setCodigo(request.getParameter("codigo"));
        asig.setNombre(request.getParameter("nombre"));
        asig.setHoras(Integer.parseInt(request.getParameter("horas")));
        asig.setTipo(request.getParameter("tipo"));
        asig.setCreditos(Integer.parseInt(request.getParameter("creditos")));
        // Llamar al método insertar o actualizar del DAO
        if (accion.equals("guardar")) {
            asignaturaDao.insertar(asig);
        } else {
            asignaturaDao.actualizar(asig);
        }
        HttpSession sesion = request.getSession();
        sesion.setAttribute("asignaturas", asignaturaDao.buscarTodos());
        // La vista permite asociar una redirección
        RequestDispatcher vista = request.getRequestDispatcher(LISTAR_ASIGNATURAS);
        vista.forward(request, response);
    }
}
