<%@page import="java.util.List" %>
<%@page import="es.avalon.services.*"%>
<%@page import="es.avalon.dominio.*"%>

<%LibroPersonaService servicio = new LibroPersonaService();
    List<Libro> lista = servicio.buscarTodosLosLibros();

%>

<html>
    <head>
    </head>
    <body>
        <table>
            <tr>
                <th>
                    Autor
                </th>
                <th>
                    ISBN
                </th>
                <th>
                    Titulo
                </th>
            </tr>
            <%for (Libro lib:lista) { %>
            <tr>
                <td><%=lib.getAutor()%></td>
                <td><%=lib.getIsbn()%></td>
                <td><%=lib.getTitulo()%></td>
                <td><a href="borrarLibro.jsp?ISBN=<%=lib.getIsbn()%>">borrar</a></td>
            </tr>
            <%}%>
        </table>
        <a href="formularioLibro.jsp">Insertar Libro</a>
    </body>
</html>