<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import = "pildorasInfo.productos.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style>

table
{
	float:left;
}

#ContenedorBoton
{
	margin-left:1000px;
}
</style>
</head>

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
	<c:forEach var="tempProd" items="${LISTAPRODUCTOS}">

	<!-- LINK ACTUALIZAR CADA PRODUCTO CON CAMPO CLAVE -->
	
	<c:url var="linkTemp" value="ControladorProductos">
		
		<c:param name="instruccion" value="cargar"></c:param>
		<c:param name="cArticulo" value="${tempProd.cArt}"></c:param>
		
		<!-- Con esta ultima linea enviamos el codigo del articulo, para saber cual actualizar -->
	</c:url>
	
	<!-- LINK PARA ELIMINAR PRODUCTO CON CAMPO CLAVE -->
	<c:url var="linkEliminar" value="ControladorProductos">
		
		<c:param name="instruccion" value="eliminar"></c:param>
		<c:param name="cArticulo" value="${tempProd.cArt}"></c:param>
		
		<!-- Con esta ultima linea enviamos el codigo del articulo, para saber cual actualizar -->
	</c:url>
	
	
	<tr>
			<td>${tempProd.cArt}</td>
			<td>${tempProd.seccion} </td>
			<td>${tempProd.nArt} </td>
			<td>${tempProd.fecha} </td>
			<td>${tempProd.precio} </td>
			<td>${tempProd.importando} </td>
			<td>${tempProd.orig} </td>
			<td><a href="${linkTemp}">Actualizar</a>&nbsp;<a href="${linkEliminar}">Eliminar</a></td>
	</tr>	
	
	</c:forEach>
</table>
<div id="ContenedorBoton">
	<input type="button" value="Insertar" onclick="window.location.href='InsertaRegistro.jsp'"/>
	
</div>
</body>
</html>