package pildorasInfo.productos;

import java.io.*;
import java.sql.*;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.*;


@WebServlet("/ServletPruebas")
public class ServletPruebas extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    //DEFINIR EL DATASOURSE
	@Resource(name="jdbc/Productos")
	private DataSource miPool;

	public ServletPruebas() 
    {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//Creamos el objeto PrintWriter
		PrintWriter salida=response.getWriter();
		
		response.setContentType("text/plain");
		
		//Creamos la conexion con la BBDD
		Connection miConexion = null;
		Statement miState = null;
		ResultSet miRS = null; 
		
		try
		{
			miConexion = miPool.getConnection();
			
			String miSql = "SELECT * FROM PRODUCTOS";
			
			miState = miConexion.createStatement();
			
			miRS = miState.executeQuery(miSql);
			
			while(miRS.next())
			{
				String nombreArt = miRS.getString(3);
				
				salida.println(nombreArt);
			}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		doGet(request, response);
	}

}
