<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8"/>
	<link rel="stylesheet" type="text/css" href="css/estilizacao.css">
	<link rel="stylesheet" type="text/css" href="css/estiloTelaLogin.css">
	<title>Login</title>
</head>
<body>
	<main id="mainLogin">
		<fieldset id="fieldsetLogin" class="cLogin">
		    <h1>Login</h1><br>
		    <form action="index.jsp" method="post">
			    <input id="inputUsuario" class="cLoginInput" type="text" name="usuario" placeholder="Usuário" autofocus><br><br>
			    <input id="inputSenha" class="cLoginInput" type="password" name="senha" placeholder="Senha"><br><br>
			    <input id="inputEntrar" class="cBotaoInput" type="submit" value="Entrar">
		    </form>
	    </fieldset>
	</main>
<%
	String usuario = request.getParameter("usuario");
	String senha = request.getParameter("senha");
	if(usuario!=null && senha!=null && !usuario.isEmpty() && !senha.isEmpty()){
		session.setAttribute("usuarioSession", usuario);
		response.sendRedirect("venda.jsp");
	}
%>
</body>
</html>