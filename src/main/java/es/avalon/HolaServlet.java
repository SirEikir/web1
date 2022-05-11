package es.avalon;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.avalon.dominio.Libro;
import es.avalon.repository.LibroRepository;


public class HolaServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        PrintWriter pw = response.getWriter();
        LibroRepository repositorio = new LibroRepository();
        List<Libro> lista = repositorio.buscarTodos();
        response.setContentType("text/html");
        for (Libro libro:lista){
            pw.println("<p>"+libro.getAutor()+"</p>");
            pw.println("<p>"+libro.getIsbn()+"</p>");
            pw.println("<p>"+libro.getTitulo()+"</p>");
        }
        
       
        
    }

    
}
