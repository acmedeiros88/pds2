<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>  
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8"/>
	<link rel="stylesheet" type="text/css" href="css/estilizacao.css">
	<link rel="stylesheet" type="text/css" href="css/estiloTelaHist-Balanc.css">
	<style>
		#historicoNav {
		 background-color: grey;
		 color: white;
		}
	</style>
	<title>Histórico</title>
</head>
<body>
	<main>
		<c:import url="menuPrincipal.jsp" />
		
			<section id="sectionHistorico">
			<h1>HISTÓRICO</h1>
			<form>
				<div id="camposHistorico" class="camposInput" style="margin-left: 25%;">
					<label class="cInputLabelData">Périodo:</label>
					<br>
					<input type="date" name="dataInicPeriodoHistorico" id="inputDataInicPeriodoHistorico" placeholder="dd/mes/ano">
					<label class="cInputLabelData" style="margin: 1% 1% 1% 1%">à</label>
					<input type="date" name="dataFimPeriodoHistorico" id="inputDataFimPeriodoHistorico" placeholder="dd/mes/ano">
					<br>
					<input type="text" name="nomeClienteHistorico" id="inputNomeClienteHistorico" placeholder="Consultar por Cliente">
					<br>
					<input type="text" name="produtoHistorico" id="inputProdutoHistorico" placeholder="Consultar por Produto">
					<br>
					<input type="button" name="buttonBuscarHistorico" id="inputButtonBuscarHistorico" value="Buscar">
					<br>
					<table id="tableHistorico">
						<tr>
							<th>Data</th>
							<th>Produto</th>
							<th>Tipo</th>
							<th>Quantidade</th>
							<th>Valor</th>
						</tr>
						<tr>
							<td>01/01/2019</td>
							<td>produto01</td>
							<td>bolo</td>
							<td>1</td>
							<td>R$6,00</td>
						</tr>
						<tr>
							<td>01/01/2019</td>
							<td>produto02</td>
							<td>bolo</td>
							<td>1</td>
							<td>R$6,00</td>
						</tr>
						<tr>
							<td>01/01/2019</td>
							<td>produto03</td>
							<td>salgado</td>
							<td>1</td>
							<td>R$6,00</td>
						</tr>
					</table>
					<br>
					<label class="cInputLabelTotalHistorico">Total de Unidade</label>
					<input type="number" name="totalUndHistorico" id="inputTotalUndHistorico" readonly>
					<label class="cInputLabelTotalHistorico" style="margin-left: 2%;">Valor Total</label>
					<input type="number" name="totalVendidoHistorico" id="inputTotalVendidoHistorico" readonly>
				</div>
			</form>	
		</section>
	</main>
</body>
</html>