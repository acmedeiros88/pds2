<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%> 
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="UTF-8"/>
	<link rel="stylesheet" type="text/css" href="css/estilizacao.css">
	<link rel="stylesheet" type="text/css" href="css/estiloTelaPedido.css">
	<style>
		#produzidosNav {
		 background-color: grey;
		 color: white;
		}
	</style>
	<title>Produzidos</title>
</head>
<body>
	<main>
		<c:import url="menuPrincipal.jsp" />
		
		<section id="sectionProduzidos">
			<h1 style="margin-left: 28%">ITENS PRODUZIDOS</h1>
			<form>
				<div id="pedidosFeitos">
					<table id="tableProduzidos">
						<tr>
							<th>
								<input type="checkbox" name="pedido">
							</th>
							<th>Código</th>
							<th>Cliente</th>
							<th>Produto</th>
						</tr>
						<tr>
							<td><input type="checkbox" name="pedido"></td>
							<td>001</td>
							<td>cliente01</td>
							<td>produto01</td>
						</tr>
						<tr>
							<td><input type="checkbox" name="pedido"></td>
							<td>001</td>
							<td>cliente01</td>
							<td>produto01</td>
						</tr>
						<tr>
							<td><input type="checkbox" name="pedido"></td>
						    <td>001</td>
							<td>cliente01</td>
							<td>produto01</td>
						</tr>
					</table>
				</div>
				<div>
					<input id="inputForaPedido" type="button" name="foraPedido" value="Fora">
					<input id="inputVendaPedido" type="button" name="vendaPedido" value="Venda">
				</div>
			</form>	
		</section>
	</main>
</body>
</html>