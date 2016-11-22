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
		
		//INICIAR TRANSA��O PARA PERSIST�NCIA NO BANCO.
		this.manager.getTransaction().begin();
		
		//SALVAR OS DADOS QUE EST�O NOS OBJETOS.
		this.manager.merge(boleto);
		
		//FAZER A PERSIST�NCIA ENVIANDOS COMANDOS PARA O BANCO.
		this.manager.flush();
		
		//CONFIRMA TODA TRANSA��O COM O BANCO.
		this.manager.getTransaction().commit();		
	}
	
	public void alterarBoleto(Boleto boleto){
		
		//INICIAR TRANSA��O PARA PERSIST�NCIA NO BANCO.
		this.manager.getTransaction().begin();
		
		//SALVAR OS DADOS QUE EST�O NOS OBJETOS.
		this.manager.merge(boleto);
		
		//FAZER A PERSIST�NCIA ENVIANDOS COMANDOS PARA O BANCO.
		this.manager.flush();
		
		//CONFIRMA TODA TRANSA��O COM O BANCO.
		this.manager.getTransaction().commit();
	}
	
	public void excluirBoleto(Boleto boleto){
		
		//INICIAR A TRANSA��O PARA PERSIST�NCIA NO BANCO.
		this.manager.getTransaction().begin();
		
		//FAZ A REMO��O DOS DADOS.
		this.manager.remove(boleto);
		
		//ENVIANDOS COMANDOS PARA O BANCO PARA REMO��O DOS DADOS.
		this.manager.flush();
		
		//CONFIRMA TODA TRANSA��O COM O BANCO.
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