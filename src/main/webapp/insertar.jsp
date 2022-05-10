<%@page import="java.util.List" %>
<%@page import="es.avalon.repository.*"%>
<%@page import="es.avalon.dominio.*"%>

<%
//Creamos un repositorio
PersonaRepositoy repo= new PersonaRepositoy();

//leer de la web los datos de la persona
String dni = request.getParameter("dni");
String nombre = request.getParameter("nombre");
int edad = Integer.parseInt(request.getParameter("edad"));

//Crear una persona en memoria
Persona p = new Persona(dni, nombre, edad);

//usar el repositorio para acceder ala base de datos e insertar
repo.insertar(p);

//volver a cargar el listado con los datos nuevos
response.sendRedirect("lista.jsp");


%>