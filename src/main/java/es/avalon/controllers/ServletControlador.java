package es.avalon.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.avalon.dominio.Persona;
import es.avalon.services.LibroPersonaService;

// /controlador como url--->lista.jsp

public class ServletControlador extends HttpServlet {

    LibroPersonaService servicio = new LibroPersonaService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getParameter("accion") != null) {

            if (request.getParameter("accion").equals("formulariopersona")) {
                RequestDispatcher despachador = request.getRequestDispatcher("personas/formulario.jsp");
                despachador.forward(request, response);

            }else if (request.getParameter("accion").equals("borrarpersona")) {

                String dni=request.getParameter("dni");
                // crear una persona en memoria
                Persona p= new Persona(dni);
                // usar el repositorio para acceder a la base de datos e insertar
                servicio.borrarPersona(p);

                cargarLista(request, response);
            } 
            
            else if (request.getParameter("accion").equals("insertarpersona")) {

                String dni = request.getParameter("dni");
                String nombre = request.getParameter("nombre");
                int edad = Integer.parseInt(request.getParameter("edad"));

                // crear una persona en memoria
                Persona p = new Persona(dni, nombre, edad);
                // usar el repositorio para acceder a la base de datos e insertar
                servicio.insertarPersona(p);

                cargarLista(request, response);

            }
            else if (request.getParameter("accion").equals("detallepersona")) {

                String dni = request.getParameter("dni");
                Persona p = new Persona(dni);
                Persona pRequest = servicio.buscarUnaPersona(p);

                RequestDispatcher despachador = request.getRequestDispatcher("personas/listaDetalle.jsp");
                request.setAttribute("persona",pRequest);
                despachador.forward(request, response);

                cargarLista(request, response);

            }

                 } else {

            cargarLista(request, response);

        }

        // lista personas que podr??a ser tu lista de yogures

    }

    private void cargarLista(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Persona> listaPersonas = servicio.buscarTodasLasPersonas();
        // oye a que tienda van a ir los yogures a que vista de la aplicacion
        RequestDispatcher despachador = request.getRequestDispatcher("personas/lista.jsp");
        // a??adir datos para la vista
        request.setAttribute("lista", listaPersonas);
        despachador.forward(request, response);
    }
}
    

