package modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import controle.Util.JPAUtil;
import controle.Util.JpaDAO;
import modelo.dominio.Cliente;

public class ClienteDAO extends JpaDAO<Cliente>{
	
	private EntityManager manager = null;
			
	public ClienteDAO(){
		
		this.manager = JPAUtil.getEntityManager();
	}
			
	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void incluirCliente(Cliente cliente){
		
		//INICIAR TRANSA��O PARA PERSIST�NCIA NO BANCO.
		this.manager.getTransaction().begin();
		
		//SALVAR OS DADOS QUE EST�O NOS OBJETOS.
		this.manager.merge(cliente);
		
		//FAZER A PERSIST�NCIA ENVIANDOS COMANDOS PARA O BANCO.
		this.manager.flush();
		
		//CONFIRMA TODA TRANSA��O COM O BANCO.
		this.manager.getTransaction().commit();		
	}
	
	public void alterarCliente(Cliente cliente){
		
		//INICIAR TRANSA��O PARA PERSIST�NCIA NO BANCO.
		this.manager.getTransaction().begin();
		
		//SALVAR OS DADOS QUE EST�O NOS OBJETOS.
		this.manager.merge(cliente);
		
		//FAZER A PERSIST�NCIA ENVIANDOS COMANDOS PARA O BANCO.
		this.manager.flush();
		
		//CONFIRMA TODA TRANSA��O COM O BANCO.
		this.manager.getTransaction().commit();
	}
	
	public void excluirCliente(Cliente cliente){
		
		//INICIAR A TRANSA��O PARA PERSIST�NCIA NO BANCO.
		this.manager.getTransaction().begin();
		
		//FAZ A REMO��O DOS DADOS.
		this.manager.remove(cliente);
		
		//ENVIANDOS COMANDOS PARA O BANCO PARA REMO��O DOS DADOS.
		this.manager.flush();
		
		//CONFIRMA TODA TRANSA��O COM O BANCO.
		this.manager.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> consultarTodosClientes(){
		
		List<Cliente> resultadoBusca;
		
		Query consulta = this.getManager().createQuery("from tabCliente c order by nome");
		
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
//			POR UMA MENSAGEM AQUI, NENHUM CLIENTE ENCONTRADO COM ESSE C�DIGO.
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
//			POR UMA MENSAGEM AQUI, NENHUM CLIENTE ENCONTRADO COM ESSE C�DIGO.
			resultadoBusca = null;
		}
		
		return resultadoBusca;
	}
	
	public Cliente lerPorNome(String nome){
		
		Cliente resultadoBusca;
		
		Query consulta = this.getManager().createQuery("from tabCliente c where c.nome = :nome");
		consulta.setParameter("nome", nome);
		
		try
		{
			resultadoBusca = (Cliente) consulta.getSingleResult();
		}
		
		catch (NoResultException e)
		{
//			POR UMA MENSAGEM AQUI, NENHUM CLIENTE ENCONTRADO COM ESSE C�DIGO.
			resultadoBusca = null;
		}
		
		return resultadoBusca;
	}

}