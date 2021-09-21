package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexion {
	
	Connection cnn;
	
	public Connection conexiondb() {
		try {
			Class.forName("com.msql.cj.jdbc.Driver");
			try {
			cnn=DriverManager.getConnection("jdbc:mysql://localhost/Tienda_virtual","root","");
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} 
			JOptionPane.showMessageDialog(null, "Connexion ok");
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		
		return cnn;
			
	}
	

}
