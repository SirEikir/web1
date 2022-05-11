<%@page import="java.util.List" %>
<%@page import="es.avalon.services.*"%>
<%@page import="es.avalon.dominio.*"%>

<%LibroPersonaService servicio = new LibroPersonaService();
    List<Persona> lista = servicio.buscarTodasLasPersonas();

%>

<html>
    <head>
    </head>
    <body>
        <table>
            <tr>
                <th>
                    dni
                </th>
                <th>
                    Nombre
                </th>
                <th>
                    Edad
                </th>
            </tr>
            <%for (Persona p:lista) { %>
            <tr>
                <td><%=p.getDni()%></td>
                <td><%=p.getNombre()%></td>
                <td><%=p.getEdad()%></td>
                <td><a href="borrar.jsp?dni=<%=p.getDni()%>">borrar</a></td>
            </tr>
            <%}%>
        </table>
        <a href="formulario.jsp">Insertar</a>
    </body>
</html>