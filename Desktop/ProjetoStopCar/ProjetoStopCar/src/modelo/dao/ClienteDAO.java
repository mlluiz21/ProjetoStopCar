package modelo.dao;

import javax.persistence.EntityManager;

import modelo.dominio.Cliente;

public class ClienteDAO {
	
	private EntityManager manager = null;
	
	public String salvar(Cliente cliente)
	{
		return "clienteEditar";
	}

	public Object remover(Cliente cliente)
	{
		return null;
		
	}

	public Cliente lerTodos() {
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
