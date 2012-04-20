package br.com.clientes.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.clientes.controle.ClienteControle;
import br.com.clientes.entity.Cliente;

public class RemoverClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		
		Cliente cliente = new Cliente();
		cliente.setCpf(request.getParameter("cpf"));
		
		ClienteControle clienteBean = new ClienteControle();
		
		clienteBean.deletar(cliente);
		
		response.sendRedirect("clientes.jsp");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
