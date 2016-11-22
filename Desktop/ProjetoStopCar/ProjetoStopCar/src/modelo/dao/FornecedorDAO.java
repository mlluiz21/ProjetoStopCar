package modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.dominio.Fornecedor;

public class FornecedorDAO {
	
private EntityManager manager = null;
	
	public FornecedorDAO(){
		
		this.manager = JPAUtil.getEntityManager();
	}
			
	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void incluirFornecedor(Fornecedor fornecedor){
		
		//INICIAR TRANSA��O PARA PERSIST�NCIA NO BANCO.
		this.manager.getTransaction().begin();
		
		//SALVAR OS DADOS QUE EST�O NOS OBJETOS.
		this.manager.merge(fornecedor);
		
		//FAZER A PERSIST�NCIA ENVIANDOS COMANDOS PARA O BANCO.
		this.manager.flush();
		
		//CONFIRMA TODA TRANSA��O COM O BANCO.
		this.manager.getTransaction().commit();		
	}
	
	public void alterarFornecedor(Fornecedor fornecedor){
		
		//INICIAR TRANSA��O PARA PERSIST�NCIA NO BANCO.
		this.manager.getTransaction().begin();
		
		//SALVAR OS DADOS QUE EST�O NOS OBJETOS.
		this.manager.merge(fornecedor);
		
		//FAZER A PERSIST�NCIA ENVIANDOS COMANDOS PARA O BANCO.
		this.manager.flush();
		
		//CONFIRMA TODA TRANSA��O COM O BANCO.
		this.manager.getTransaction().commit();
	}
	
	public void excluirFornecedor(Fornecedor fornecedor){
		
		//INICIAR A TRANSA��O PARA PERSIST�NCIA NO BANCO.
		this.manager.getTransaction().begin();
		
		//FAZ A REMO��O DOS DADOS.
		this.manager.remove(fornecedor);
		
		//ENVIANDOS COMANDOS PARA O BANCO PARA REMO��O DOS DADOS.
		this.manager.flush();
		
		//CONFIRMA TODA TRANSA��O COM O BANCO.
		this.manager.getTransaction().commit();
	}
	
	public void consultarFornecedor(Fornecedor fornecedor){
		
		this.manager.getTransaction().begin();
				
	}
	
	@SuppressWarnings("unchecked")
	public List<Fornecedor> consultarFornecedor(){
		
		List<Fornecedor> resultadoBusca;
		
		Query consulta = this.getManager().createQuery("from tabFornecedor f order by codFornecedor and nome");
		
		try
		{
			resultadoBusca = (List<Fornecedor>) consulta.getResultList();
		}
		
		catch (NoResultException e)
		{
			resultadoBusca = null;
		}
		
		return resultadoBusca;
				
	}
		
	public Fornecedor lerPorCodigo(Long codFornecedor){
		
		Fornecedor resultadoBusca;
		
		Query consulta = this.getManager().createQuery("from tabFornecedor f where f.codFornecedor = :codFornecedor");
		consulta.setParameter("codFornecedor", codFornecedor);
		
		try
		{
			resultadoBusca = (Fornecedor) consulta.getSingleResult();
		}
		
		catch (NoResultException e)
		{
//			POR UMA MENSAGEM AQUI, NENHUM CLIENTE ENCONTRADO COM ESSE C�DIGO.
			resultadoBusca = null;
		}
		
		return resultadoBusca;
	}
	
	public Fornecedor lerPorCnpj(int cnpj){
		
		Fornecedor resultadoBusca;
		
		Query consulta = this.getManager().createQuery("from tabFornecedor f where f.cnpj = :cnpj");
		consulta.setParameter("cnpj", cnpj);
		
		try
		{
			resultadoBusca = (Fornecedor) consulta.getSingleResult();
		}
		
		catch (NoResultException e)
		{
//			POR UMA MENSAGEM AQUI, NENHUM CLIENTE ENCONTRADO COM ESSE C�DIGO.
			resultadoBusca = null;
		}
		
		return resultadoBusca;
	}

	public Fornecedor lerPorRazaoSocial(String razaoSocial){
		
		Fornecedor resultadoBusca;
		
		Query consulta = this.getManager().createQuery("from tabFornecedor f where f.razaoSocial = :razaoSocial");
		consulta.setParameter("razaoSocial", razaoSocial);
		
		try
		{
			resultadoBusca = (Fornecedor) consulta.getSingleResult();
		}
		
		catch (NoResultException e)
		{
//			POR UMA MENSAGEM AQUI.
			resultadoBusca = null;
		}
		
		return resultadoBusca;
	}
}
