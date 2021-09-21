package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import modelo.UsuarioDAO;
import modelo.UsuarioDTO;

/**
 * Servlet implementation class ServletGestionUsuario
 */
@WebServlet("ServletGestionUsuario")
public class ServletGestionUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletGestionUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int d;
		String u,c,r;
		boolean re;
		UsuarioDTO usdto; 
		UsuarioDAO usdao;
		UsuarioDTO recolectad;
		
		if(request.getParameter("btncrear")!=null) {
			//crear
			d=Integer.parseInt(request.getParameter("documento"));
			u=request.getParameter("usuario");
			c=request.getParameter("contraseña");
			r=request.getParameter("rol");
			
			usdto = new UsuarioDTO(d,u,c,r);
			usdao = new UsuarioDAO();
			re=usdao.insertarus(usdto);
			
			if(re) {
				JOptionPane.showMessageDialog(null, "Usuario registrado");
				response.sendRedirect("usuario.jsp");
			}else {
				JOptionPane.showMessageDialog(null, "Usuario no registrado");
				response.sendRedirect("usuario.jsp");
			}
			
		}
		
		if(request.getParameter("btncons")!=null) {
			//consultar
			int documento;
			d=Integer.parseInt(request.getParameter("documento"));
			usdto= new UsuarioDTO(d);
			usdao= new UsuarioDAO();
			recolectad=usdao.consultarus(usdto);
			documento= recolectad.getDocumento_usuario();
			u= recolectad.getUsuario();
			c= recolectad.getContraseña();
			r= recolectad.getRol();
			response.sendRedirect("usuario.jsp?d="+d+"&&u="+u+"&&c="+c+"&&r="+r);
		}
		
		if(request.getParameter("btnact")!=null) {
			//actualizar
			boolean dato;
			d=Integer.parseInt(request.getParameter("documento"));
			u=request.getParameter("usuario");
			c=request.getParameter("contraseña");
			r=request.getParameter("rol");
			usdto=new UsuarioDTO(d,u,c,r);
			usdao=new UsuarioDAO();
			dato=usdao.actualizar(usdto);
			if(dato==true) {
				JOptionPane.showMessageDialog(null, "El usuario se actualizo");
				response.sendRedirect("usuario.jsp");
			}
			else {
				JOptionPane.showMessageDialog(null, "El usuario no se actualizo");
				response.sendRedirect("usuario.jsp");
			}

		}
		
		if(request.getParameter("btnbor")!=null) {
			//borrar
			int x;
			d=Integer.parseInt(request.getParameter("documento"));
			usdto=new UsuarioDTO(d);
			usdao=new UsuarioDAO();
			x= usdao.eliminar(usdto);
			if(x>0){
				JOptionPane.showMessageDialog(null, "El usuario fue eliminado");
				response.sendRedirect("usuario.jsp");
			}
			else {
				JOptionPane.showMessageDialog(null, "El usuario no fue eliminado");
				response.sendRedirect("usuario.jsp");
			}
		}
	}

}
