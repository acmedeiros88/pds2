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
		#pedidoNav {
		 background-color: grey;
		 color: white;
		}
	</style>
	<title>Pedido</title>
</head>
<body>
	<main>
			<c:import url="menuPrincipal.jsp" />
			
		    <section id="sectionPedido">
			<h1>PEDIDO</h1>
			<form>
				<div>
					<input id="inputNomeClientePedido" type="text" name="nomeClientePedido" placeholder="Nome Cliente" autofocus>
					<br>
					<input list="produtosPedido" id="inputListaProdutosPedido" name="listaProdutosPedido" placeholder="Produto">
						<datalist id="produtosPedido">
							<option value="Bolo"></option>
							<option value="Salgado"></option>
						</datalist>
					<label>Quantidade:</label>
					<input id="inputQuantidadeProdutoPedido" type="number" name="quantidadeProdutoPedido" min="1" placeholder="und">
					<br>
					<label>Data de entrega:</label>
					<input type="date" name="dataEntrega" id="inputDataEntrega" placeholder="dd/mes/ano">
					<input id="inputSalvarPedido" type="button" name="salvarPedido" value="Salvar">
				</div>
				<div id="pedidosFeitos">
					<legend>Lista de Pedidos Feitos</legend>
					<table id="tablePedido">
						<tr>
							<th><input type="checkbox" name="novoPedido"></th>
							<th>Código</th>
							<th>Cliente</th>
							<th>Data Solicitado</th>
							<th>Data Entrega</th>
							<th>Detalhes</th>
						</tr>
						<tr>
							<td><input type="checkbox" name="novoPedido"></td>
							<td>001</td>
							<td>Cliente01</td>
							<td>01/01/2019</td>
							<td>02/01/2019</td>
							<td>detralhes</td>
						</tr>
						<tr>
							<td><input type="checkbox" name="novoPedido"></td>
							<td>002</td>
							<td>Cliente01</td>
							<td>01/01/2019</td>
							<td>02/01/2019</td>
							<td>detralhes</td>
						</tr>
						<tr>
							<td><input type="checkbox" name="novoPedido"></td>
							<td>003</td>
							<td>cliente01</td>
							<td>01/01/2019</td>
							<td>02/01/2019</td>
							<td>detalhes</td>
						</tr>
					</table>
				</div>
				<div>
					<input id="inputItenProduzido" type="button" name="itenProduzido" value="Produzido">
					<input id="inputExcluirPedido" type="button" name="excluirPedido" value="Excluir">
				</div>
			</form>	
		</section>
	</main>
</body>
</html>