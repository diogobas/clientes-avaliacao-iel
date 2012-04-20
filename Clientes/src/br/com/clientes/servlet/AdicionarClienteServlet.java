package br.com.clientes.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.clientes.controle.ClienteControle;
import br.com.clientes.entity.Cliente;

public class AdicionarClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		
		String dataNascimento = request.getParameter("nascimento") ;
		
		Date data = null;
		try {
			data = new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimento);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Cliente novoCliente = new Cliente();
		novoCliente.setNome(request.getParameter("nome"));
		novoCliente.setCpf(request.getParameter("cpf"));
		novoCliente.setDataNascimento(data);
		novoCliente.setTelefone(request.getParameter("telefone"));
		novoCliente.setEmail(request.getParameter("email"));
		novoCliente.setStatus(true);
		
		ClienteControle controle = new ClienteControle();
		
		if(!controle.inserir(novoCliente)){
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
