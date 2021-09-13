<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="estilo.css">
<title>Login</title>
</head>
<body>
 <!-- MENU -->
<center>
  <div class="contenedor" style="margin-top: 5%">
    <h1>Bienvenidos a la Tienda Genérica</h1>
      <div id="login" style="margin-top: 3%">
       <form  action="Servletlogin" method="get">
  
   <table style="with:80%">
     <tr>
       <td>Usuario</td>
       <td> <input type="text" name="usuario"  requered></td>
     </tr>
     
     <tr >
       <td>Contraseña</td>
       <td> <input type="password" name="clave" requered></td>
     </tr> 
   </table>
    
     <br>
     <button>Aceptar</button>
     <button>Cancelar</button>
    
     </form>
    </div>
  </div>
</center>

</body>
</html>