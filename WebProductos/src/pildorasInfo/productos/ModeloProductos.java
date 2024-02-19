package pildorasInfo.productos;

import java.sql.*;
import java.util.*;

import javax.sql.*;

public class ModeloProductos 
{
	private DataSource origenDatos;
	
	public ModeloProductos(DataSource origenDatos)
	{
		this.origenDatos = origenDatos;
	}
	
	public List<Productos> getProductos() throws Exception
	{
		List<Productos> productos = new ArrayList<>();
		
		Connection miConexion = null;
		Statement miState = null;
		ResultSet miRS = null;
		
		//   ESTEBLECEMOS LA CONEXION GRACIAS AL POOL
		miConexion = origenDatos.getConnection();
		
		String sql = "SELECT * FROM PRODUCTOS";
		miState = miConexion.createStatement();
		
		miRS = miState.executeQuery(sql);
		
		//RECORREMOS EL RESULT SET
		while(miRS.next())
		{
			String cArt = miRS.getString(1);
			String sec = miRS.getString(2);
			String nArt = miRS.getString(3);
			Double precio = miRS.getDouble(4);
			String fecha = miRS.getString(5);
			String importado = miRS.getString(6);
			String pOrig = miRS.getString(7);
			
			Productos tempPro = new Productos(cArt,sec,nArt,precio,fecha,importado,pOrig);
			
			productos.add(tempPro);
		}
		
		return productos;
	}

	public void agregaNuevoProducto(Productos nuevoProd) throws Exception
	{
		//Obtener conexion
		Connection miConexion = null;
		PreparedStatement miState = null;
		
		try
		{
			miConexion = origenDatos.getConnection();
			
			//Creamos la instruccion para insertar
			String sql = "INSERT INTO PRODCUTOS(CÓDIGOARTÍCULO, SECCIÓN, NOMBREARTÍCULO, PRECIO, FECHA, IMPORTADO, PAÍSORIGEN) "
					+ "VALUES(?,?,?,?,?,?,?)";
			
			miState = miConexion.prepareStatement(sql);
			//Establecemos parametros para el producto
			miState.setString(1, nuevoProd.getcArt());
			miState.setString(2, nuevoProd.getSeccion());
			miState.setString(3, nuevoProd.getnArt());
			miState.setDouble(4, nuevoProd.getPrecio());
			miState.setString(5, nuevoProd.getFecha());
			miState.setString(6, nuevoProd.getImportado());
			miState.setString(7, nuevoProd.getOrig());
			
			/*
			 * EN EL CASO DE QUE FECHA FUERA TIPO DATE SE PONE ESTAS LINEAS
			 * 
			 * PERO DEVULEVE UN DATE DEL PAQUETE SQL y usamos el de el paquete UTIL
			 * por tanto debemos convertir al del paquete UTIL
			 * 
			 * java.util.Date utilDate = nuevoProd.getFecha();
			 * java.sql.Date fechaConvertida = new java.sql.Date(utilDate.getTime());
			 * 
			 * miState.setDate(5, fechaConvertida);
			 */
			
			//Ejecutamos la instruccion
		}
		
		catch(Exception e)
		{
			
		}
		finally
		{
			miConexion.close();
			miState.close();
		}
		

	}
	
	public Productos getProducto(String codigoArt) throws Exception
	{
		Productos elProduc = null;
		Connection miConexion = null;
		PreparedStatement miST = null;
		ResultSet miRS = null;
		String codArt = codigoArt;
		
		//Establece Conexion
		try
		{
			miConexion = origenDatos.getConnection();
			
			//Busca producto
			String sql = "SELECT * FROM PRODUCTOS WHERE CÓDIGOARTÍCULO=?";
			miST = miConexion.prepareStatement(sql);
			miST.setString(1, codArt);
			miRS = miST.executeQuery();
			
			//Obtenemos los datos de respuesta
			if(miRS.next())
			{
				String cArt = miRS.getString(1);
				String sec = miRS.getString(2);
				String nArt = miRS.getString(3);
				Double precio = miRS.getDouble(4);
				String fecha = miRS.getString(5);
				String importado = miRS.getString(6);
				String pOrig = miRS.getString(7);
				
				elProduc = new Productos(cArt,sec,nArt,precio,fecha,importado,pOrig);
			}
			
			else	
			{
				throw new Exception("No se encontro cArt: "+ codigoArt);
			}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			miConexion.close();
			miST.close();
			miRS.close();
		}
		
		return elProduc;
	}

	public void actualizaProduc(Productos productoActualizado) throws Exception
	{
		Connection miConexion = null;
		PreparedStatement miState = null;
		
		//Establecer conexion
		miConexion = origenDatos.getConnection();
		
		//Creamos la sentencia SQL
		String sql = "UPDATE PRODUCTOS SET SECCIÓN=?, NOMBREARTÍCULO?, PRECIO=?,"
				+ "FECHA=?, IMPORTADO=?, PAÍSORIGEN=?, WHERE CÓDIGOARTÍCULO=?";
		
		miState = miConexion.prepareStatement(sql);
		
		miState.setString(1, productoActualizado.getSeccion());
		miState.setString(2, productoActualizado.getnArt());
		miState.setDouble(3, productoActualizado.getPrecio());
		miState.setString(4, productoActualizado.getFecha());
		miState.setString(5, productoActualizado.getImportado());
		miState.setString(6, productoActualizado.getOrig());
		miState.setString(7, productoActualizado.getcArt());
		
		//Ejecutamos la instruccion
		miState.execute();
		
		//Siempre cerrar conexiones
		miConexion.close();
		miState.close();
	}

	public void eliminarProductos(String cArt) throws Exception
	{
		
		Connection miConexion = null;
		PreparedStatement miState = null;
		
		//Establecer conexion
		miConexion = origenDatos.getConnection();
				
		//Creamos la sentencia SQL
		String sql = "DELETE FROM PRODUCTOS WHERE CÓDIGOARTÍCULO=?";
		miState = miConexion.prepareStatement(sql);
		miState.setString(1, cArt);
		
		//Ejecutamos la instruccion
		miState.execute();
		
		miConexion.close();
		miState.close();
	}
}
