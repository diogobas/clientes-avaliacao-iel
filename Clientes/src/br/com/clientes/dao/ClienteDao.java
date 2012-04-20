package br.com.clientes.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.clientes.entity.Cliente;
import br.com.clientes.util.Conexao;

public class ClienteDao extends GenericDao<Cliente>{
	
	private EntityManager em = Conexao.getEntityManager();
	
	@SuppressWarnings("unchecked")
	public List<Cliente> getListaDeClientes(){
		Session sessao = (Session) em.getDelegate();

		Criteria criteria = sessao.createCriteria(Cliente.class);
		
		criteria.add(Restrictions.eq("status", true));
		
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> getListaDeClientesInativos(){
		Session sessao = (Session) em.getDelegate();

		Criteria criteria = sessao.createCriteria(Cliente.class);
		
		criteria.add(Restrictions.eq("status", false));
		
		return criteria.list();
	}
	
	public Cliente consultarPorCPF(String cpf) {
		Session sessao = (Session) em.getDelegate();

		Criteria criteria = sessao.createCriteria(Cliente.class);
		criteria.add(Restrictions.like("cpf", cpf));
		
		return (Cliente) criteria.uniqueResult();
	}
	
	public Boolean verificaExistenciaCPF(String cpf){
		Session sessao = (Session) em.getDelegate();

		Criteria criteria = sessao.createCriteria(Cliente.class);
		criteria.add(Restrictions.like("cpf", cpf));
		Cliente cliente = (Cliente) criteria.uniqueResult();
		
		if(cliente != null){
			return false;
		}
		
		return true;
	}
}
