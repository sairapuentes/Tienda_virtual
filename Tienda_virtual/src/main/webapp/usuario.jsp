<%@page import="controlador.Conexion" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="estilo.css">
<title>Insert title here</title>
</head>
<body>

<%
Conexion con = new Conexion();
con.conexiondb();
%>

  <header class="cont_header" id="cont" >
         <div class="contenedor" style="margin-top: 5%">
    <h1>Bienvenidos a la Tienda Genérica</h1>
      <div id="login" style="margin-top: 3%">
      
  <form  action="ServletGestionUsuario" method="post">
  
   <table style="with:80%">
   
    <tr>
       <td>Documento</td>
       <td> <input type="text" name="documento"  requered></td>
     </tr>
     
     <tr>
       <td>Usuario</td>
       <td> <input type="text" name="usuario"  requered></td>
     </tr>
     
     <tr >
       <td>Contraseña</td>
       <td> <input type="password" name="contraseña" requered></td>
     </tr> 
     
      <tr>
       <td>Rol</td>
       <td> <input type="text" name="rol"  requered></td>
     </tr>
   </table>


    <div class="contenedor-dos">
        <li>   
            <button type="submit" class="btncons"> Consultar</button>
            <button type="submit" class="btncrear"> Crear</button>  
            <button type="submit" class="btnact"> Actualizar</button>
            <button type="submit" class="btnbor"> Borrar</button>
        </li>

        
    </div>


            </ul>
        </nav>   

    </header>

</body>
</html>