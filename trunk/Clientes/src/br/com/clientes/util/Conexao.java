package br.com.clientes.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexao {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("clientes");
	
	public static EntityManager getEntityManager(){
		return emf.createEntityManager();
	}
}
