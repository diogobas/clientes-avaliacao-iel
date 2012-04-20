<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="clientesBean" scope="session" class="br.com.clientes.controle.ClienteControle"/>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clientes</title>
    </head>
    <body>
        <h1>Novo Cliente</h1>
        <form action="AdicionarClienteServlet">
        <table border="1">
            <tr>
            	<td>CPF</td>
				<td>Nome</td>
				<td>Data Nascimento</td>
				<td>Telefone</td>
				<td>Email</td>
			</tr>
            <tr>
            	<td><input type="text" name="cpf" size="11"/></td>
                <td><input type="text" name="nome" size="50"/></td>
                <td><input type="text" name="nascimento" size="20"/></td>
                <td><input type="text" name="telefone" size="20"/></td>
                <td><input type="text" name="email" size="30"/></td>
            </tr>
        </table>
        
        <input type="submit" value="Salvar"/>
    </form>
    </body>
</html>
