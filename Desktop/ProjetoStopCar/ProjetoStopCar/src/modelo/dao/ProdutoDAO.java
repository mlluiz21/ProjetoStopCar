package modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.dominio.Produto;

public class ProdutoDAO {
	
private EntityManager manager = null;
	
	public ProdutoDAO(){
		
		this.manager = JPAUtil.getEntityManager();
	}
	
	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void incluirProduto(Produto produto){
		
		//INICIAR TRANSA��O PARA PERSIST�NCIA NO BANCO.
		this.manager.getTransaction().begin();
		
		//SALVAR OS DADOS QUE EST�O NOS OBJETOS.
		this.manager.merge(produto);
		
		//FAZER A PERSIST�NCIA ENVIANDOS COMANDOS PARA O BANCO.
		this.manager.flush();
		
		//CONFIRMA TODA TRANSA��O COM O BANCO.
		this.manager.getTransaction().commit();		
	}
	
	public void alterarProduto(Produto produto){
		
		//INICIAR TRANSA��O PARA PERSIST�NCIA NO BANCO.
		this.manager.getTransaction().begin();
		
		//SALVAR OS DADOS QUE EST�O NOS OBJETOS.
		this.manager.merge(produto);
		
		//FAZER A PERSIST�NCIA ENVIANDOS COMANDOS PARA O BANCO.
		this.manager.flush();
		
		//CONFIRMA TODA TRANSA��O COM O BANCO.
		this.manager.getTransaction().commit();
	}
	
	public void excluirProduto(Produto produto){
		
		//INICIAR A TRANSA��O PARA PERSIST�NCIA NO BANCO.
		this.manager.getTransaction().begin();
		
		//FAZ A REMO��O DOS DADOS.
		this.manager.remove(produto);
		
		//ENVIANDOS COMANDOS PARA O BANCO PARA REMO��O DOS DADOS.
		this.manager.flush();
		
		//CONFIRMA TODA TRANSA��O COM O BANCO.
		this.manager.getTransaction().commit();
	}
	
	public void consultarProduto(Produto produto){
		
		this.manager.getTransaction().begin();
				
	}

	@SuppressWarnings("unchecked")
	public List<Produto> consultarProduto(){
		
		List<Produto> resultadoBusca;
		
		Query consulta = this.getManager().createQuery("from tabProduto p order by codProduto and nomeProduto");
		
		try
		{
			resultadoBusca = (List<Produto>) consulta.getResultList();
		}
		
		catch (NoResultException e)
		{
			resultadoBusca = null;
		}
		
		return resultadoBusca;
				
	}
		
	public Produto lerPorCodigo(Long codProduto){
		
		Produto resultadoBusca;
		
		Query consulta = this.getManager().createQuery("from tabProduto p where p.codProduto = :codProduto");
		consulta.setParameter("codProduto", codProduto);
		
		try
		{
			resultadoBusca = (Produto) consulta.getSingleResult();
		}
		
		catch (NoResultException e)
		{
//			POR UMA MENSAGEM AQUI, NENHUM CLIENTE ENCONTRADO COM ESSE C�DIGO.
			resultadoBusca = null;
		}
		
		return resultadoBusca;
	}
	
	public Produto lerPorNomeProduto(String nomeProduto){
		
		Produto resultadoBusca;
		
		Query consulta = this.getManager().createQuery("from tabProduto p where p.nomeProduto = :nomeProduto");
		consulta.setParameter("nomeProduto", nomeProduto);
		
		try
		{
			resultadoBusca = (Produto) consulta.getSingleResult();
		}
		
		catch (NoResultException e)
		{
//			POR UMA MENSAGEM AQUI, NENHUM CLIENTE ENCONTRADO COM ESSE C�DIGO.
			resultadoBusca = null;
		}
		
		return resultadoBusca;
	}

}