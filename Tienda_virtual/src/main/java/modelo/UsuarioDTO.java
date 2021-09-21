package modelo;

public class UsuarioDTO {

	private int documento_usuario;
	private String Usuario;
	private String Contraseña;
	private String Rol;
	
	public UsuarioDTO(int documento_usuario, String usuario, String contraseña, String rol) {
		this.documento_usuario = documento_usuario;
		this.Usuario = usuario;
		this.Contraseña = contraseña;
		this.Rol = rol;
	}

	
	
	public UsuarioDTO(int documento_usuario) {
		this.documento_usuario = documento_usuario;
	}



	public int getDocumento_usuario() {
		return documento_usuario;
	}

	public void setDocumento_usuario(int documento_usuario) {
		this.documento_usuario = documento_usuario;
	}

	public String getUsuario() {
		return Usuario;
	}

	public void setUsuario(String usuario) {
		Usuario = usuario;
	}

	public String getContraseña() {
		return Contraseña;
	}

	public void setContraseña(String contraseña) {
		Contraseña = contraseña;
	}

	public String getRol() {
		return Rol;
	}

	public void setRol(String rol) {
		Rol = rol;
	}
	
	
	
	
	
}
