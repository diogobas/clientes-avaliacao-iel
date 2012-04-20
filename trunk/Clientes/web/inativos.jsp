<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="clientesBean" scope="session" class="br.com.clientes.controle.ClienteControle"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Clientes</title>
	</head>
	<body>
	<h1>Clientes Removidos</h1>
	<table border="1">
		<tr>
			<td>CPF</td>
			<td>Nome</td>
			<td>Data Nascimento</td>
			<td>Telefone</td>
			<td>Email</td>
		</tr>
		
		<c:forEach items="${clientesBean.listaDeClientesInativos}" var="cliente">
			<tr>
				<td>${cliente.cpf}</td>
				<td><a href="show.jsp?name=${cliente.nome}">${cliente.nome}</a></td>
				<td>${cliente.dataNascimento}</td>
				<td>${cliente.telefone}</td>
				<td>${cliente.email}</td>
				<td><a href="AtivarClienteServlet?cpf=${cliente.cpf}">Ativar</a></td>
			</tr>
		</c:forEach>
	</table>
	<input type="submit" value="Voltar" onclick="location.href='clientes.jsp'" />
	</body>
</html>