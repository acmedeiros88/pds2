<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page language="java" import="entity.Cliente" %> 
<!DOCTYPE html>
<html>
<head lang="pt-br">
	<meta charset="UTF-8"/>
	<link rel="stylesheet" type="text/css" href="css/estilizacao.css">
	<link rel="stylesheet" type="text/css" href="css/estiloTelaCliente.css">
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<style>
		#clienteNav {
		 background-color: grey;
		 color: white;
		}
	</style>
	<title>Cliente</title>
</head>
<body>
	<main>
	    <c:import url="menuPrincipal.jsp" />
	    
		<section id="sectionCliente">
			<h1>CLIENTE</h1>
			<form action="GerenciarCliente" method="post">
				<nav class="subMenu">
					<ul>
						<li name="gerenciar" class="cCliente" style="padding: 3.05% 1.6% 1% 1%">
							<input type="radio" name="tabs" id="inputGerenciarCliente" class="cInputSubMenu" checked>
							<label for="inputGerenciarCliente">Gerenciar</label>
							<div class="contentArticle">
								<article id="gerenciar" class="conteudoTab">
									<input id="inputTelefoneCliente" type="text" name="telefoneCliente" placeholder="Telefone" value="">
									<br>
									<input id="inputNomeCliente" type="text" name="nomeCliente" placeholder="Nome" value="">
									<br>
									<input id="inputEstabelecimentoCliente" type="text" name="estabelecimentoCliente" placeholder="Estabelecimento" value="">
									<br>
									<textarea id="textareaObservacaoCliente" name="observacaoCliente" placeholder="Observação" value=""></textarea>
									<br>
									<input id="inputSalvarCadastroCliente" type="submit" value="Salvar" name="acao">
									<input id="inputExcluirCadastroCliente" type="submit" value="Excluir" name="acao">
									<input id="inputCancelarCadastroCliente" type="reset" value="Cancelar">
								</article>
							</div>
						</li>
						<li name="consultarCompras" class="cCliente">
							<input type="radio" name="tabs" id="inputConsultarCompras" class="cInputSubMenu">
							<label for="inputConsultarCompras">Consultar Compras</label>
							<div class="contentArticle">
								<article id="consultarCompras" class="conteudoTab" style="margin-left: -16.2%;">
									<input type="text" id="inputNomeClienteConsultarCompras" name="nomeClienteConsultarCompras" placeholder="Nome">
									<br>
									<input id="inputTelefoneClienteConsultarCompras" type="number" name="telefoneClienteConsultarCompras" min="1" placeholder="Telefone" style="width: 49%;">
									<input type="button" id="inputBuscarClienteConsultarCompras" name="buscarClienteConsultarCompras" value="Buscar" style="width: 10%; height: 34px;">
									<legend style="margin-left: 5%;">Lista de Compras Feitas</legend>
									<table id="tableListaComprasFeitas" style="width: 61%;">
										<tr>
											<th>Data</th>
											<th>Produto</th>
											<th>Valor</th>
											<th>Situação</th>
										</tr>
										<tr>
											<td></td>
											<td></td>
											<td></td>
											<td>								
												<select name="situacaoCompraCliente" id="selectSituacaoCompraCliente" style="width: 75%;">
													<option value="pendente">Pendente</option>
													<option value="pago">Pago</option>
												</select>
											</td>
										</tr>
									</table>
									<br>
									<input id="inputSalvarSaidaProduto" type="submit" name="salvarSaidaProduto" value="Salvar">
									<input id="inputCancelarSaidaProduto" type="reset" name="cancelarSaidaProduto" value="Cancelar">
								</article>
							</div>
						</li>
					</ul>
				</nav>
			</form>	
		</section>
	</main>
	<script>
	
	$(function() {
		$("#inputTelefoneCliente").focusout(function() {
			if($(this).val()!=''){
				$("form").submit();
			}	
		});
	});
	</script>
	<%if(request.getAttribute("mensagem")!=null){ %>
		<script>
		var msn = '<%=request.getAttribute("mensagem") %>';
		if(msn!=null){
			alert(msn);
		}
		</script>
	<%} %>
	<%if(request.getAttribute("cliente")!=null){ %>
		<% Cliente cliente =(Cliente) request.getAttribute("cliente");%>
		<script>
		$(document).ready(function() {
				$("#inputTelefoneCliente").val('<%=cliente.getNumTelefone()%>');
				$("#inputNomeCliente").val('<%= cliente.getNomeCliente() %>');
				$("#inputEstabelecimentoCliente").val('<%= cliente.getEstabelecimentoCliente() %>');
				$("#textareaObservacaoCliente").val('<%= cliente.getObservacaoCliente() %>');
		});
		</script>
	<%}if((request.getAttribute("mensagem")==null)){%>
		<script>
		$(document).ready(function() {
				$("#inputTelefoneCliente").val(<%=request.getParameter("telefoneCliente")%>);
		});
		</script>
	<%}else{%>
		<script>
		$(document).ready(function() {
				$("#inputTelefoneCliente").focus();
		});
		</script>
	<%}%>
</body>
</html>