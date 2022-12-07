package Modelo;

public class Ventas {
	int idEmpleado;
	int idCliente;
	String Monto;
	String Fecha;
	
	public Ventas() {
		
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getMonto() {
		return Monto;
	}

	public void setMonto(String monto) {
		this.Monto = monto;
	}

	public String getFecha() {
		return Fecha;
	}

	public void setFecha(String fecha) {
		this.Fecha = fecha;
	}

	

}
