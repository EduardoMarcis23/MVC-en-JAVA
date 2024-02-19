<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<h1 style="text-align:center">Actualizar</h1>
<form name="form1" method="get" action="ControladorProductos">
<input type="hidden" name="cArt" value="${ProductoActualizar.cArt}">

	<table>
<!--SE COMENTA YA QUE EL USUARIO NO DEBE MOVER EL CODIGO YA QUE ESTA ACTUALIZANDO
	<tr>
	<td width="28%">Codigo</td>
	<td width="75%"><label for="cArt"></label>
	<input type="text" name="cArt" id="cArt"></td>
	</tr>-->
	<tr>
	<td> Seccion</td>
	<td><label for="seccion"></label>
	<input type="text" name="seccion" id="seccion" value="${ProductoActualizar.cArt.secccion}"></td>
	</tr>
	<tr>
	<td> Nombre</td>
	<td><label for="nArt"></label>
	<input type="text" name="nArt" id="nArt" value="${ProductoActualizar.nArt}"></td>
	</tr>
	<tr>
	<td> FECHA</td>
	<td><label for="fecha"></label>
	<input type="text" name="fecha" id="fecha" value="${ProductoActualizar.fecha}"></td>
	</tr>
	<tr>
	<td> PRECIO</td>
	<td><label for="precio"></label>
	<input type="text" name="precio" id="precio" value="${ProductoActualizar.precio}"></td>
	</tr>
	<tr>
	<td> IMPORTADO</td>
	<td><label for="importado"></label>
	<input type="text" name="importado" id="importado" value="${ProductoActualizar.importado}"></td>
	</tr>
	<tr>
	<td> PAIS</td>
	<td><label for="Orig"></label>
	<input type="text" name="Orig" id="Orig" value="${ProductoActualizar.o rig}"></td>
	</tr>
	<tr>
		<td> <input type="submit" name="envio" id="envio" value="envio"></td>
		<td> <input type="reset" name="borrar" id="borrar" value="borrar"></td>
	</table>
</form> 
</body>
</html>