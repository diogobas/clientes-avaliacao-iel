package br.com.clientes.bo;

import java.util.List;

import br.com.clientes.dao.GenericDao;
import br.com.clientes.entity.Entidade;



public abstract class GenericBo<En> {
	
	@SuppressWarnings("unchecked")
	private GenericDao<En> getDao(En e){
		Object dao = null;
		try {
			Class classe = e.getClass();
			String nomeCompleto = classe.getName();
			nomeCompleto = nomeCompleto.replaceAll(".entity.", ".dao.");
			nomeCompleto += "Dao";
			Class classeDao = Class.forName(nomeCompleto); 
			dao = Class.forName (classeDao.getName()).newInstance();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} 
		return (GenericDao<En>) dao;
	}
	
	public void inserir(En e){
		getDao(e).inserir(e);
	}

	public Entidade consultar(Entidade e){
		return getDao((En) e).consultar(e);
	}
	
	public List<Entidade> consultarTodos(Entidade e){
		return getDao((En) e).consultarTodos(e);
	}

	public void alterar(En e){
		getDao(e).alterar(e);
	}

	public void deletar(Entidade e){
		getDao((En) e).deletar(e);
	}
}
