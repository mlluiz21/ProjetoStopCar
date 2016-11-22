package modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.dominio.Boleto;

public class BoletoDAO {
	
private EntityManager manager = null;
	
	public BoletoDAO(){
		
		this.manager = JPAUtil.getEntityManager();
	}
	
	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void incluirBoleto(Boleto boleto){
		
		//INICIAR TRANSAÇÃO PARA PERSISTÊNCIA NO BANCO.
		this.manager.getTransaction().begin();
		
		//SALVAR OS DADOS QUE ESTÃO NOS OBJETOS.
		this.manager.merge(boleto);
		
		//FAZER A PERSISTÊNCIA ENVIANDOS COMANDOS PARA O BANCO.
		this.manager.flush();
		
		//CONFIRMA TODA TRANSAÇÃO COM O BANCO.
		this.manager.getTransaction().commit();		
	}
	
	public void alterarBoleto(Boleto boleto){
		
		//INICIAR TRANSAÇÃO PARA PERSISTÊNCIA NO BANCO.
		this.manager.getTransaction().begin();
		
		//SALVAR OS DADOS QUE ESTÃO NOS OBJETOS.
		this.manager.merge(boleto);
		
		//FAZER A PERSISTÊNCIA ENVIANDOS COMANDOS PARA O BANCO.
		this.manager.flush();
		
		//CONFIRMA TODA TRANSAÇÃO COM O BANCO.
		this.manager.getTransaction().commit();
	}
	
	public void excluirBoleto(Boleto boleto){
		
		//INICIAR A TRANSAÇÃO PARA PERSISTÊNCIA NO BANCO.
		this.manager.getTransaction().begin();
		
		//FAZ A REMOÇÃO DOS DADOS.
		this.manager.remove(boleto);
		
		//ENVIANDOS COMANDOS PARA O BANCO PARA REMOÇÃO DOS DADOS.
		this.manager.flush();
		
		//CONFIRMA TODA TRANSAÇÃO COM O BANCO.
		this.manager.getTransaction().commit();
	}
	
	public void consultarBoleto(Boleto boleto){
		
		this.manager.getTransaction().begin();
				
	}

	@SuppressWarnings("unchecked")
	public List<Boleto> consultarBoleto(){
		
		List<Boleto> resultadoBusca;
		
		Query consulta = this.getManager().createQuery("from tabBoleto b order by codBoleto and nome");
		
		try
		{
			resultadoBusca = (List<Boleto>) consulta.getResultList();
		}
		
		catch (NoResultException e)
		{
			resultadoBusca = null;
		}
		
		return resultadoBusca;
				
	}
		
	public Boleto lerPorCodigo(Long codBoleto){
		
		Boleto resultadoBusca;
		
		Query consulta = this.getManager().createQuery("from tabBoleto b where b.codBoleto = :codBoleto");
		consulta.setParameter("codBoleto", codBoleto);
		
		try
		{
			resultadoBusca = (Boleto) consulta.getSingleResult();
		}
		
		catch (NoResultException e)
		{
//			POR UMA MENSAGEM AQUI.
			resultadoBusca = null;
		}
		
		return resultadoBusca;
	}
	
		
	@SuppressWarnings("unchecked")
	public List<Boleto> lerPorServico(String servico){
		
		List<Boleto> resultadoBusca;
		
		Query consulta = this.getManager().createQuery("from tabBoleto b where b.servico = :servico");
		consulta.setParameter("servico", servico);
		
		try
		{
			resultadoBusca = (List<Boleto>) consulta.getResultList();
		}
		
		catch (NoResultException e)
		{
//			POR UMA MENSAGEM AQUI.
			resultadoBusca = null;
		}
		
		return resultadoBusca;
	}

}