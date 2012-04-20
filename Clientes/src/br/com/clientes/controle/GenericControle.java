package br.com.clientes.controle;

import br.com.clientes.bo.GenericBo;


public abstract class GenericControle<Entidade> {
	
	//metodo que retorna uma instância da classe Bo baseado no nome da classe de entidade.
	@SuppressWarnings("unchecked")
	protected GenericBo<Entidade> getBo(Entidade e){
		Object bo = null;
		try {
			Class classe = e.getClass();
			String nomeCompleto = classe.getName();
			nomeCompleto = nomeCompleto.replaceAll(".entity.", ".bo.");
			nomeCompleto += "Bo";
			Class classeBo = Class.forName(nomeCompleto); 
			bo = Class.forName (classeBo.getName()).newInstance();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}  
		return (GenericBo<Entidade>) bo;
	}
	
	public abstract void inserir();	
	public abstract void consultar();
	protected abstract void alterar();
	public abstract void deletar();
}
