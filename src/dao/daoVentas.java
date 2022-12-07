package dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Modelo.Ventas;
import crud.conexion;

public class daoVentas {
	conexion cx = null;

	public daoVentas() {
		cx = new conexion();
	}

	public boolean insertarVentas(Ventas vent) {
		PreparedStatement ps = null;
		try {
			ps = cx.conectar().prepareStatement("INSERT INTO Ventas VALUES(null,?,?,?)");
			ps.setString(1, vent.getMonto());
			ps.setString(2, convertirSHA256(vent.getFecha()));
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<Ventas> fetchUsusarios() {
		ArrayList<Ventas> lista = new ArrayList<Ventas>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = cx.conectar().prepareStatement("SELECT * FROM Ventas");
			rs = ps.executeQuery();
			while (rs.next()) {
				Ventas u = new Ventas();
				u.setIdEmpleado(rs.getInt("idEmpleado"));
				u.setIdCliente(rs.getInt("idCliente"));
				u.setMonto(rs.getString("monto"));
				u.setFecha(rs.getString("fecha"));
				lista.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	public boolean loginVentas(Ventas vent) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = cx.conectar().prepareStatement("SELECT * FROM Ventas WHERE vent=? AND password=?");
			ps.setString(1, vent.getMonto());
			ps.setString(2, convertirSHA256(vent.getFecha()));
			rs = ps.executeQuery();
	        if (rs.next()) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


	public boolean eliminarVentas(int Id) {
		PreparedStatement ps = null;
		try {
			ps = cx.conectar().prepareStatement("DELETE FROM  Ventas WHERE id=?");
			ps.setInt(1, Id);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean editarVentas(Ventas vent) {
		PreparedStatement ps = null;
		try {
			ps = cx.conectar().prepareStatement("UPDATE Ventas SET vent=?,password=?,nombre=? WHERE id=?");
			ps.setString(1, vent.getFecha());
			ps.setString(2, convertirSHA256(vent.getMonto()));
			ps.setInt(4, vent.getIdCliente());
			ps.setInt(4, vent.getIdEmpleado());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public String convertirSHA256(String password) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
		byte[] hash = md.digest(password.getBytes());
		StringBuffer sb = new StringBuffer();

		for (byte b : hash)
			sb.append(String.format("%02x", b));
		return sb.toString();
	}
}
