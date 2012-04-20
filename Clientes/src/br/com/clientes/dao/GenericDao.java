package br.com.clientes.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;

import br.com.clientes.entity.Entidade;
import br.com.clientes.util.Conexao;


public abstract class GenericDao<En> {

	private EntityManager em = Conexao.getEntityManager();
	
	public void inserir(En e){
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
	}
	
	public Entidade consultar(Entidade e){
		return em.find(e.getClass(), e.getId());
	}
	
	@SuppressWarnings("unchecked")
	public List<Entidade> consultarTodos(Entidade e){
		Session sessao = (Session) em.getDelegate();

		Criteria criteria = sessao.createCriteria(e.getClass());
		
		return criteria.list();
	}
	
	public void alterar(En e){
		em.getTransaction().begin();
		em.merge(e);
		em.getTransaction().commit();
	}
	
	public void deletar(Entidade e){
		em.getTransaction().begin();
		em.remove(e);
		em.getTransaction().commit();
	}
	
}
