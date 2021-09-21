package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.cj.protocol.Resultset;

import controlador.Conexion;

public class UsuarioDAO {

	
	Conexion con = new Conexion();
	Connection cnn = con.conexiondb();
	PreparedStatement ps;
	Resultset result;
	UsuarioDTO usu ;
	
	public boolean insertarus(UsuarioDTO us) {
		
		int x;
		boolean dato = false;
		
		try {
			ps=cnn.prepareStatement("INSERT INTO usuario VALUES(?,?,?,?)");
			ps.setInt(1, us.getDocumento_usuario());
			ps.setString(2, us.getUsuario());
			ps.setString(3, us.getContraseña());
			ps.setString(4, us.getRol());

			x=ps.executeUpdate();
			
			if(x>0) {
				dato = true;
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al insertar"+e);
		}
		return dato;
	}
	
	public UsuarioDTO consultarus(UsuarioDTO us) {
		
		try {
			ps=cnn.prepareStatement("SELECT * FROM usuario WHERE VALUES documento_usuario=?");
			ps.setInt(1, us.getDocumento_usuario());
			result=(Resultset) ps.executeQuery();
			
			if(((ResultSet) result).next()) {
				usu = new UsuarioDTO( ((ResultSet) result).getInt(1), ((ResultSet) result).getString(2), ((ResultSet) result).getString(3), ((ResultSet) result).getString(4));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usu;
		
	}
	
	public boolean actualizar(UsuarioDTO us) {
		boolean dato=false;
		int x;
		try {
			ps=cnn.prepareStatement("UPDATE clientes SET Usuario=?,	Contraseña=?, Rol=? WHERE documento_usuario=?");
		    ps.setString(1, us.getUsuario());
		    ps.setString(2, us.getContraseña());
		    ps.setString(3, us.getRol()); 
		    ps.setInt(4, us.getDocumento_usuario());
		   x= ps.executeUpdate();
		   if(x>0) {
			   dato= true;
		   }

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dato;
	}
	
	public int eliminar(UsuarioDTO us) {
		int x=0;
		try {
			ps=cnn.prepareStatement("DELETE FROM usuario WHERE documento_usuario=?");
		    ps.setInt(1, us.getDocumento_usuario());
		   x= ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	return x;
  }

}
