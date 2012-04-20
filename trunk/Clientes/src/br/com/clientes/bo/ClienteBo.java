package br.com.clientes.bo;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.clientes.dao.ClienteDao;
import br.com.clientes.entity.Cliente;
import br.com.clientes.util.Email;

public class ClienteBo extends GenericBo<Cliente>{
	
	private ClienteDao dao = new ClienteDao();
	
	public List<Cliente> getListaDeClientes(){
		return dao.getListaDeClientes();
	}
	
	public List<Cliente> getListaDeClientesInativos(){
		return dao.getListaDeClientesInativos();
	}
	
	public Cliente consultarPorCPF(String cpf) {
		return dao.consultarPorCPF(cpf);
	}
	
	public Boolean verificaExistenciaCPF(String cpf){
		return dao.verificaExistenciaCPF(cpf);
	}
	
	public Integer getIdade(Date data) {
		GregorianCalendar hj=new GregorianCalendar();
		GregorianCalendar nascimento=new GregorianCalendar();
		if(data!=null){
			nascimento.setTime(data);
		}		
		int anohj=hj.get(Calendar.YEAR);
		int anoNascimento=nascimento.get(Calendar.YEAR);
		return new Integer(anohj-anoNascimento);
	}
	
	public void enviarEmailSucesso(Cliente cliente){
		Email email = new Email();
		
		StringBuilder stringMensagem = new StringBuilder("Olá ");
		
		String separador = System.getProperty("line.separator"); 
		
		stringMensagem.append(cliente.getNome()).append("!");
		stringMensagem.append(separador).append(separador).append("O Cliente com o CPF de número ").append(cliente.getCpf()).append(" foi criado com sucesso!");
		stringMensagem.append(separador).append(separador).append("Obrigado!");
		
		String mensagem = stringMensagem.toString();
		
		email.enviaEmail("avaliacaotecnicaiel@gmail.com", cliente.getEmail(), "Cliente cadastrado com sucesso!", mensagem);
	}
	
	public void enviarEmailAlterado(Cliente cliente){
		Email email = new Email();
		
		StringBuilder stringMensagem = new StringBuilder("Olá ");
		
		String separador = System.getProperty("line.separator"); 
		
		stringMensagem.append(cliente.getNome()).append("!");
		stringMensagem.append(separador).append(separador).append("O Cliente com o CPF de número ").append(cliente.getCpf()).append(" foi alterado com sucesso!");
		stringMensagem.append(separador).append(separador).append("Obrigado!");
		
		String mensagem = stringMensagem.toString();
		
		email.enviaEmail("avaliacaotecnicaiel@gmail.com", cliente.getEmail(), "Cliente cadastrado com sucesso!", mensagem);
	}
}
