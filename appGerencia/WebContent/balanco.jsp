<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%> 
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="UTF-8"/>
	<link rel="stylesheet" type="text/css" href="css/estilizacao.css">
	<link rel="stylesheet" type="text/css" href="css/estiloTelaHist-Balanc.css">
	<style>
		#balancoNav {
		 background-color: grey;
		 color: white;
		}
	</style>
	<title>Balanço</title>
</head>
<body>
	<main>
		<c:import url="menuPrincipal.jsp" />
			
		<section id="sectionBalanco">
			<h1>BALANÇO</h1>
			<form>
				<div id="camposBalanco" class="camposInput" style="margin-left: 25%;">
					<label class="cInputLabelData">Périodo:</label>
					<br>
					<input type="date" name="dataInicPeriodoBalanco" id="inputDataInicPeriodoBalanco" placeholder="dd/mes/ano">
					<label class="cInputLabelData" style="margin: 1% 1% 1% 1%">à</label>
					<input type="date" name="dataFimPeriodoBalanco" id="inputDataFimPeriodoBalanco" placeholder="dd/mes/ano">
					<br>
					<input type="button" name="buttonBuscarBalanco" id="inputButtonBuscarBalanco" value="Buscar">
					<br>
					<legend>Vendas</legend>
					<table id="tableBalancoVendas">
						<tr>
							<th>Quantidade</th>
							<th>Valor Total</th>
						</tr>
						<tr>
							<td>1</td>
							<td>R$00,00</td>
						</tr>
					</table>
					<br>
					<legend>Custos</legend>
					<table id="tableBalancoCustos">
						<tr>
							<th>Valor Total</th>
						</tr>
						<tr>
							<td>R$00,00</td>
						</tr>
					</table>
				</div>
			</form>	
		</section>
	</main>
</body>
</html>