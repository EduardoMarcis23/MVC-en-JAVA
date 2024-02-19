<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import = "java.util.*, pildorasInfo.productos.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<%
	//OBTENEMOS LOS PRODUCTOS DEL CONTROLADOR(SERVELET)
	List<Productos> losProduc = (List<Productos>) request.getAttribute("LISTAPRODUCTOS");

%>
<body>
<table>
<tr>
	<td>Codigo</td>
	<td>Seccion</td>
	<td>Nombre</td>
	<td>Fecha</td>
	<td>Precio</td>
	<td>Importado</td>
	<td>P.Origen</td>
</tr>
	<%	for(Productos produc : losProduc)
		{	%>
			<tr>
			<td><%=produc.getcArt() %></td>
			<td><%=produc.getSeccion() %></td>
			<td><%=produc.getnArt() %></td>
			<td><%=produc.getFecha() %></td>
			<td><%=produc.getPrecio()%></td>
			<td><%=produc.getImportado() %></td>
			<td><%=produc.getOrig() %></td>
			</tr>
	<%	} %>	
		
</table>
</body>
</html>