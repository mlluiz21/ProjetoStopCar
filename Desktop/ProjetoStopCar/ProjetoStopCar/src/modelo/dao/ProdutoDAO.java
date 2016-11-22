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
		
		//INICIAR TRANSAÇÃO PARA PERSISTÊNCIA NO BANCO.
		this.manager.getTransaction().begin();
		
		//SALVAR OS DADOS QUE ESTÃO NOS OBJETOS.
		this.manager.merge(produto);
		
		//FAZER A PERSISTÊNCIA ENVIANDOS COMANDOS PARA O BANCO.
		this.manager.flush();
		
		//CONFIRMA TODA TRANSAÇÃO COM O BANCO.
		this.manager.getTransaction().commit();		
	}
	
	public void alterarProduto(Produto produto){
		
		//INICIAR TRANSAÇÃO PARA PERSISTÊNCIA NO BANCO.
		this.manager.getTransaction().begin();
		
		//SALVAR OS DADOS QUE ESTÃO NOS OBJETOS.
		this.manager.merge(produto);
		
		//FAZER A PERSISTÊNCIA ENVIANDOS COMANDOS PARA O BANCO.
		this.manager.flush();
		
		//CONFIRMA TODA TRANSAÇÃO COM O BANCO.
		this.manager.getTransaction().commit();
	}
	
	public void excluirProduto(Produto produto){
		
		//INICIAR A TRANSAÇÃO PARA PERSISTÊNCIA NO BANCO.
		this.manager.getTransaction().begin();
		
		//FAZ A REMOÇÃO DOS DADOS.
		this.manager.remove(produto);
		
		//ENVIANDOS COMANDOS PARA O BANCO PARA REMOÇÃO DOS DADOS.
		this.manager.flush();
		
		//CONFIRMA TODA TRANSAÇÃO COM O BANCO.
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
//			POR UMA MENSAGEM AQUI, NENHUM CLIENTE ENCONTRADO COM ESSE CÓDIGO.
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
//			POR UMA MENSAGEM AQUI, NENHUM CLIENTE ENCONTRADO COM ESSE CÓDIGO.
			resultadoBusca = null;
		}
		
		return resultadoBusca;
	}

}