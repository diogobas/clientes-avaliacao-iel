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

public class AlterarClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		
		Cliente cliente = new Cliente();
		
		ClienteControle controle = new ClienteControle();
		
		cliente = controle.consultarPorCPF(request.getParameter("cpf"));
		
		String dataNascimento = request.getParameter("dataNascimento") ;
		
		Date data = null;
		try {
			data = new SimpleDateFormat("yyyy-MM-dd").parse(dataNascimento);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		cliente.setNome(request.getParameter("nome"));
		cliente.setDataNascimento(data);
		cliente.setTelefone(request.getParameter("telefone"));
		cliente.setEmail(request.getParameter("email"));
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
