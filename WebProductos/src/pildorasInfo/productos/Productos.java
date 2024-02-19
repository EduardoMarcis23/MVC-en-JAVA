package pildorasInfo.productos;

public class Productos
{
	private String cArt,seccion,nArt,importado,orig;
	private double precio;
	private String fecha;
	
	public Productos(String cArt, String seccion, String nArt, double precio, String fecha, String importado, String orig) 
	{
		this.cArt = cArt;
		this.seccion = seccion;
		this.nArt = nArt;
		this.importado = importado;
		this.orig = orig;
		this.precio = precio;
		this.fecha = fecha;
	}

	public Productos(String seccion, String nArt, double precio, String fecha, String importado, String orig) 
	{
		this.seccion = seccion;
		this.nArt = nArt;
		this.importado = importado;
		this.orig = orig;
		this.precio = precio;
		this.fecha = fecha;
	}

	public String getcArt()
	{
		return cArt;
	}

	public void setcArt(String cArt) 
	{
		this.cArt = cArt;
	}

	public String getSeccion()
	{
		return seccion;
	}

	public void setSeccion(String seccion)
	{
		this.seccion = seccion;
	}

	public String getnArt()
	{
		return nArt;
	}

	public void setnArt(String nArt) 
	{
		this.nArt = nArt;
	}

	public String getImportado() 
	{
		return importado;
	}

	public void setImportado(String importado) 
	{
		this.importado = importado;
	}

	public String getOrig() 
	{
		return orig;
	}

	public void setOrig(String orig) 
	{
		this.orig = orig;
	}

	public double getPrecio() 
	{
		return precio;
	}

	public void setPrecio(double precio) 
	{
		this.precio = precio;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha)
	{
		this.fecha = fecha;
	}

	@Override
	public String toString()
	{
		return "Productos [cArt=" + cArt + ", seccion=" + seccion + ", nArt=" + nArt + ", importado=" + importado
				+ ", orig=" + orig + ", precio=" + precio + ", fecha=" + fecha + "]";
	}
}
