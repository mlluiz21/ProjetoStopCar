package modelo.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.dominio.Servico;

public class ServicoDAO {
	
private EntityManager manager = null;
	
	public ServicoDAO(){
		
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

	public void incluirServico(Servico servico){
		
		//INICIAR TRANSA��O PARA PERSIST�NCIA NO BANCO.
		this.manager.getTransaction().begin();
		
		//SALVAR OS DADOS QUE EST�O NOS OBJETOS.
		this.manager.merge(servico);
		
		//FAZER A PERSIST�NCIA ENVIANDOS COMANDOS PARA O BANCO.
		this.manager.flush();
		
		//CONFIRMA TODA TRANSA��O COM O BANCO.
		this.manager.getTransaction().commit();		
	}
	
	public void alterarServico(Servico servico){
		
		//INICIAR TRANSA��O PARA PERSIST�NCIA NO BANCO.
		this.manager.getTransaction().begin();
		
		//SALVAR OS DADOS QUE EST�O NOS OBJETOS.
		this.manager.merge(servico);
		
		//FAZER A PERSIST�NCIA ENVIANDOS COMANDOS PARA O BANCO.
		this.manager.flush();
		
		//CONFIRMA TODA TRANSA��O COM O BANCO.
		this.manager.getTransaction().commit();
	}
	
	public void excluirServico(Servico servico){
		
		//INICIAR A TRANSA��O PARA PERSIST�NCIA NO BANCO.
		this.manager.getTransaction().begin();
		
		//FAZ A REMO��O DOS DADOS.
		this.manager.remove(servico);
		
		//ENVIANDOS COMANDOS PARA O BANCO PARA REMO��O DOS DADOS.
		this.manager.flush();
		
		//CONFIRMA TODA TRANSA��O COM O BANCO.
		this.manager.getTransaction().commit();
	}
	
	public void consultarServico(Servico servico){
		
		this.manager.getTransaction().begin();
				
	}

}