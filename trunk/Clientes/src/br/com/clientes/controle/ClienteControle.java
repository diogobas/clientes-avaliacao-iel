package br.com.clientes.controle;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.clientes.bo.ClienteBo;
import br.com.clientes.entity.Cliente;

@ManagedBean
public class ClienteControle extends GenericControle<Cliente>{
	
	//Entidade a ser persistida
	private Cliente cliente = new Cliente();
	private ClienteBo clienteBo = (ClienteBo) getBo(cliente);

	@Override
	public void inserir() {
		if (cliente.getId() == null){
			clienteBo.inserir(cliente);
		}else{
			alterar();
		}
	}
	
	@Override
	public void consultar() {
		cliente = (Cliente) getBo(cliente).consultar(cliente);
	}

	@Override
	protected void alterar() {
		clienteBo.alterar(cliente);
	}
	
	@Override
	public void deletar() {
		clienteBo.deletar(cliente);
	}
	
	public Boolean inserir(Cliente cliente) {
		if (cliente.getId() == null || cliente.getId() == 0){
			if(validarDados(cliente)){
				clienteBo.inserir(cliente);
				enviarEmailSucesso(cliente);
				return true;
			}
		}else{
			alterar();
		}
		
		return false;
	}
	
	public Boolean alterar(Cliente cliente) {
		if(verificaMaiorIdade(cliente.getDataNascimento())){
			clienteBo.alterar(cliente);
			enviarEmailAlterado(cliente);
			return true;
		}
		
		return false;
	}
	
	public void deletar(Cliente cliente) {
		cliente = consultarPorCPF(cliente.getCpf());
		cliente.setStatus(false);
		clienteBo.alterar(cliente);
	}
	
	public void enviarEmailSucesso(Cliente cliente){
		clienteBo.enviarEmailSucesso(cliente);
	}
	
	public void enviarEmailAlterado(Cliente cliente){
		clienteBo.enviarEmailAlterado(cliente);
	}
	
	public Boolean validarDados(Cliente cliente){
		if(verificaExistenciaCPF(cliente.getCpf())){
			if(verificaMaiorIdade(cliente.getDataNascimento())){
				return true;
			}
		}
		
		return false;
	}
	
	public Boolean verificaMaiorIdade(Date nascimento){
		if(getIdade(nascimento) > 18){
			return true;
		}
		
		return false;
	}
	
	public Integer getIdade(Date data) {
		return clienteBo.getIdade(data);
	}
	
	public Boolean verificaExistenciaCPF(String cpf){
		return clienteBo.verificaExistenciaCPF(cpf);
	}
	
	public List<Cliente> getListaDeClientes(){
		return clienteBo.getListaDeClientes();
	}
	
	public List<Cliente> getListaDeClientesInativos(){
		return clienteBo.getListaDeClientesInativos();
	}
	
	public Cliente consultarPorCPF(String cpf) {
		return clienteBo.consultarPorCPF(cpf);
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
