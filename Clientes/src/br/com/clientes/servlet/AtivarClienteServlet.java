package br.com.clientes.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.clientes.controle.ClienteControle;
import br.com.clientes.entity.Cliente;

public class AtivarClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		
		Cliente cliente = new Cliente();
		
		ClienteControle controle = new ClienteControle();
		
		cliente = controle.consultarPorCPF(request.getParameter("cpf"));
		
		cliente.setStatus(true);
		
		if(!controle.alterar(cliente)){
			response.sendRedirect("erro.jsp");
			return;
		}
		
		response.sendRedirect("clientes.jsp");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
