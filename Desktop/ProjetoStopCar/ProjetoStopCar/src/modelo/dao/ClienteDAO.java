package modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelo.dominio.Cliente;

public class ClienteDAO {
	
	private EntityManager manager = null;
			
	public ClienteDAO(){
		
		super();
		
		EntityManagerFactory criandoMinhaFabrica = Persistence.createEntityManagerFactory("ProjetoBancoStopCar");
		
		this.manager = criandoMinhaFabrica.createEntityManager();
	}
			
	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void incluirCliente(Cliente cliente){
		
		//INICIAR TRANSAÇÃO PARA PERSISTÊNCIA NO BANCO.
		this.manager.getTransaction().begin();
		
		//SALVAR OS DADOS QUE ESTÃO NOS OBJETOS.
		this.manager.merge(cliente);
		
		//FAZER A PERSISTÊNCIA ENVIANDOS COMANDOS PARA O BANCO.
		this.manager.flush();
		
		//CONFIRMA TODA TRANSAÇÃO COM O BANCO.
		this.manager.getTransaction().commit();		
	}
	
	public void alterarCliente(Cliente cliente){
		
		//INICIAR TRANSAÇÃO PARA PERSISTÊNCIA NO BANCO.
		this.manager.getTransaction().begin();
		
		//SALVAR OS DADOS QUE ESTÃO NOS OBJETOS.
		this.manager.merge(cliente);
		
		//FAZER A PERSISTÊNCIA ENVIANDOS COMANDOS PARA O BANCO.
		this.manager.flush();
		
		//CONFIRMA TODA TRANSAÇÃO COM O BANCO.
		this.manager.getTransaction().commit();
	}
	
	public void excluirCliente(Cliente cliente){
		
		//INICIAR A TRANSAÇÃO PARA PERSISTÊNCIA NO BANCO.
		this.manager.getTransaction().begin();
		
		//FAZ A REMOÇÃO DOS DADOS.
		this.manager.remove(cliente);
		
		//ENVIANDOS COMANDOS PARA O BANCO PARA REMOÇÃO DOS DADOS.
		this.manager.flush();
		
		//CONFIRMA TODA TRANSAÇÃO COM O BANCO.
		this.manager.getTransaction().commit();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Cliente> consultarCliente(){
		
		List<Cliente> resultadoBusca;
		
		Query consulta = this.getManager().createQuery("from tabCliente c order by codCliente and nome");
		
		try
		{
			resultadoBusca = (List<Cliente>) consulta.getResultList();
		}
		
		catch (NoResultException e)
		{
			resultadoBusca = null;
		}
		
		return resultadoBusca;
				
	}
		
	public Cliente lerPorCodigo(Long codCliente){
		
		Cliente resultadoBusca;
		
		Query consulta = this.getManager().createQuery("from tabCliente c where c.codCliente = :codCliente");
		consulta.setParameter("codCliente", codCliente);
		
		try
		{
			resultadoBusca = (Cliente) consulta.getSingleResult();
		}
		
		catch (NoResultException e)
		{
//			POR UMA MENSAGEM AQUI, NENHUM CLIENTE ENCONTRADO COM ESSE CÓDIGO.
			resultadoBusca = null;
		}
		
		return resultadoBusca;
	}
	
	public Cliente lerPorCpf(int cpf){
		
		Cliente resultadoBusca;
		
		Query consulta = this.getManager().createQuery("from tabCliente c where c.cpf = :cpf");
		consulta.setParameter("cpf", cpf);
		
		try
		{
			resultadoBusca = (Cliente) consulta.getSingleResult();
		}
		
		catch (NoResultException e)
		{
//			POR UMA MENSAGEM AQUI, NENHUM CLIENTE ENCONTRADO COM ESSE CÓDIGO.
			resultadoBusca = null;
		}
		
		return resultadoBusca;
	}


}