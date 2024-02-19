<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<h1 style="text-align:center">Insertar</h1>
<form name="form1" method="get" action="ControladorProductos">
<input type="hidden" name="instruccion" value="insertarBBDD">
	<table>
	<tr>
	<td width="28%">Codigo</td>
	<td width="75%"><label for="cArt"></label>
	<input type="text" name="cArt" id="cArt"></td>
	</tr>
	<tr>
	<td> Seccion</td>
	<td><label for="seccion"></label>
	<input type="text" name="seccion" id="seccion"></td>
	</tr>
	<tr>
	<td> Nombre</td>
	<td><label for="nArt"></label>
	<input type="text" name="nArt" id="nArt"></td>
	</tr>
	<tr>
	<td> FECHA</td>
	<td><label for="fecha"></label>
	<input type="text" name="fecha" id="fecha"></td>
	</tr>
	<tr>
	<td> PRECIO</td>
	<td><label for="precio"></label>
	<input type="text" name="precio" id="precio"></td>
	</tr>
	<tr>
	<td> IMPORTADO</td>
	<td><label for="importado"></label>
	<input type="text" name="importado" id="importado"></td>
	</tr>
	<tr>
	<td> PAIS</td>
	<td><label for="Orig"></label>
	<input type="text" name="Orig" id="Orig"></td>
	</tr>
	<tr>
		<td> <input type="submit" name="envio" id="envio" value="envio"></td>
		<td> <input type="reset" name="borrar" id="borrar" value="borrar"></td>
	</table>
</form> 
</body>
</html>