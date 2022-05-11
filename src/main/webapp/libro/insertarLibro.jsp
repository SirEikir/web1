<%@page import="java.util.List" %>
<%@page import="es.avalon.services.*"%>
<%@page import="es.avalon.dominio.*"%>

<%
//Creamos un repositorio
LibroPersonaService servicio= new LibroPersonaService();

//leer de la web los datos de la persona
String autor = request.getParameter("autor");
int isbn = Integer.parseInt(request.getParameter("ISBN"));
String titulo = request.getParameter("titulo");


//Crear una persona en memoria
Libro lib = new Libro(autor, isbn, titulo);

//usar el repositorio para acceder ala base de datos e insertar
servicio.insertarLibro(lib);

//volver a cargar el listado con los datos nuevos
response.sendRedirect("listaLibro.jsp");


%>