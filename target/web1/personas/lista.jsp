<%@page import="java.util.List" %>
<%@page import="es.avalon.dominio.*"%>

<%
    List<Persona> lista = (List<Persona>)request.getAttribute("lista");
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
                <td><a href="/web1/controlador?accion=detallepersona&dni=<%=p.getDni()%>">Detalle</a> <a href="/web1/controlador?accion=borrarpersona&dni=<%=p.getDni()%>">borrar</a></td>
            </tr>
            <%}%>
        </table>
        <a href="/web1/controlador?accion=formulariopersona">Insertar</a>
    </body>
</html>