<%@page import="java.util.List" %>
<%@page import="es.avalon.services.*"%>
<%@page import="es.avalon.dominio.*"%>

<%
//Creamos un repositorio
LibroPersonaService servicio= new LibroPersonaService();

//leer de la web los datos de la persona
int isbn = Integer.parseInt(request.getParameter("ISBN"));

//Crear una persona en memoria
Libro lib = new Libro(isbn);

//usar el repositorio para acceder ala base de datos e insertar
servicio.borrarLibro(lib);

//volver a cargar el listado con los datos nuevos
response.sendRedirect("listaLibro.jsp");


%>