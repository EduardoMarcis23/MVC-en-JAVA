package pildorasInfo.productos;

import java.io.*;
import java.util.*;
import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.*;

@WebServlet("/ControladorProductos")
public class ControladorProductos extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	private ModeloProductos modeloProductos;
	
	 //DEFINIR EL DATASOURSE
		@Resource(name="jdbc/Productos")
		private DataSource miPool;
		
		
	//METODO DESDE EL QUE ARRANCA LA APP
	@Override
		public void init() throws ServletException
		{
			super.init();
			
			try
			{
				modeloProductos = new ModeloProductos(miPool);
			}
			
			catch(Exception e)
			{
				//LANZA UN TIPO ES PECIFICO DE EXCEPTION (ServletException)
				throw new ServletException(e);
			}
		}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//Lee el parametro que le llega desde el formulario (el oculto)
		//Si no se envia el parametro quiere decir que solo listara productos
		
		//Redirigimos al metodo insertar o listar
		
		String comando = request.getParameter("instruccion");
		
		if(comando == null) 
		{
			comando = "listar";
		}
		
		switch (comando)
		{
			case "listar":
				obtenerProductos(request,response);
				break;
				
			case "insertarBBDD":
				agregarProductos(request,response);
				break;
				
			case "cargar":
				try 
				{
					cargaProductos(request,response);
				} 
				
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			
				break;
				
			case "actualizarBBDD":
			try 
			{
				actualizaProducto(request,response);
			} 
			
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			
				break;
				
				
			case "eliminar":
				try 
				{
					eliminarProducto(request,response);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
				
				break;
				
			default:
				obtenerProductos(request,response);
				break;
		}
		
		
	}

//-------------------------------------------------------------------

	private void eliminarProducto(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		//Capturamos el cArt
		String cArt=request.getParameter("cArticulo");
		
		//Borramos de la BBDD
		modeloProductos.eliminarProductos(cArt);
		
		//Volvemos al listado
		obtenerProductos(request,response);
	}
	
	
	private void actualizaProducto(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		//Leer los datos a actualizar
		String cArt=request.getParameter("cArt");
		String seccion=request.getParameter("seccion");
		String nArt=request.getParameter("nArt");
		String fecha=request.getParameter("fecha");
		double precio=Double.parseDouble(request.getParameter("precio"));
		String importado=request.getParameter("importado");
		String Orig=request.getParameter("Orig");
		
		Productos productoActualizado = new Productos(cArt,seccion,nArt,precio,fecha,importado,Orig);
		
		//Actualizamos la BBDD
		modeloProductos.actualizaProduc(productoActualizado);

		//Volver al listado ya con la info actualizada
		obtenerProductos(request,response);
			
	}
	
	private void cargaProductos(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		//Lee el cArt que viene del listado
		String codigoArt = request.getParameter("cArticulo"); //Se recibe del param enviado en listaProductos2
		
		//Envia el cArt a modelo
		Productos elProduc = modeloProductos.getProducto(codigoArt);
		
		//Colocar atributo correspondiente al cArt
		request.setAttribute("ProductoActualizar", elProduc);
		
		//Enviamos la info al formulario de actualizar
		RequestDispatcher miDP = request.getRequestDispatcher("/ActualizarProducto.jsp");
		miDP.forward(request, response);
	}

	private void agregarProductos(HttpServletRequest request, HttpServletResponse response) 
	{
		//Leer la info del formulario
		String cArt=request.getParameter("cArt");
		String seccion=request.getParameter("seccion");
		String nArt=request.getParameter("nArt");
		/*
		 * PARA PASAR DE TEXTO A FECHA SERIA ASI
		 * 
		 * SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd")
		 * try
		 * {
		 * 		Date Fecha=formato.parse(request.getParameter("fecha"));
		 * }
		 * 
		 * catch(Exception e
		 * {
		 * 
		 * )
		 * Y SE OMITE LA LINEA DE ABAJO
		 */
		String fecha=request.getParameter("fecha");
		double precio=Double.parseDouble(request.getParameter("precio"));
		String importado=request.getParameter("importado");
		String Orig=request.getParameter("Orig");
		
		//Creamos un objeto tipo Producto
		Productos nuevoProducto = new Productos(cArt,seccion,nArt,precio,fecha,importado,Orig);
		
		//Enviar el objeto al modelo y despues insertar el objeto producto en la BBDD
		try 
		{
			modeloProductos.agregaNuevoProducto(nuevoProducto);
		} 
		
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		//Volver al listado de Productos
		obtenerProductos(request,response);
	}



	private void obtenerProductos(HttpServletRequest request, HttpServletResponse response) 
	{
		//Obtenemos la lista desde el modelo
				List<Productos> productos;
		
		try
		{
			productos = modeloProductos.getProductos();
			
			//Agregamos la lista de productos al request
			request.setAttribute("LISTAPRODUCTOS", productos);
			
			//Enviamos el request a la pagina JSP
			RequestDispatcher miDP = request.getRequestDispatcher("/ListaProductos2.jsp");
			
			miDP.forward(request, response);
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
