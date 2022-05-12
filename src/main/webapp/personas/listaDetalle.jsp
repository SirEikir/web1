
<%@page import="es.avalon.dominio.*"%>

<%
    Persona p  = (Persona)request.getAttribute("persona");
%>

<html>
    <head>
    </head>
    <body>
    <h1> Detalle del usuario seleccionado</h1>
        <p>DNI = <%=p.getDni()%></p>
        <p>Nombre =<%=p.getNombre()%></p>
        <p>Edad = <%=p.getEdad()%></p>
        <a href="/web1/controlador">Volver</a>
    </body>
</html>