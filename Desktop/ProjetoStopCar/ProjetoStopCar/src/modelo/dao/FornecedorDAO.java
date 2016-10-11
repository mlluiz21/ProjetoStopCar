package modelo.dao;

import javax.persistence.EntityManager;

import modelo.dominio.Fornecedor;

public class FornecedorDAO {

private EntityManager manager = null;
	
	public String salvar(Fornecedor fornecedor)
	{
		return "fornecedorEditar";
	}

	public Object remover(Fornecedor fornecedor)
	{
		return null;
		
	}
	
	public Fornecedor lerTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

}
