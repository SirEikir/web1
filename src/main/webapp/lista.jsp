<%@page import="java.util.List" %>
<%@page import="es.avalon.repository.*"%>
<%@page import="es.avalon.dominio.*"%>

<%PersonaRepositoy repositorio = new PersonaRepositoy();
    List<Persona> lista = repositorio.buscarTodos();

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
            </tr>
            <%}%>
        </table>
    </body>
</html>