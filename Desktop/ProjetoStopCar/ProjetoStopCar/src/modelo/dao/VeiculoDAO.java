package modelo.dao;

import javax.persistence.EntityManager;

import controle.Util.JPAUtil;
import controle.Util.JpaDAO;
import modelo.dominio.Veiculo;

public class VeiculoDAO extends JpaDAO<Veiculo>{
	
	private EntityManager manager = null;
	
	public VeiculoDAO(){
		
		this.manager = JPAUtil.getEntityManager();
	}
	
	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void incluirVeiculo(Veiculo veiculo){
		
		//INICIAR TRANSAÇÃO PARA PERSISTÊNCIA NO BANCO.
		this.manager.getTransaction().begin();
		
		//SALVAR OS DADOS QUE ESTÃO NOS OBJETOS.
		this.manager.merge(veiculo);
		
		//FAZER A PERSISTÊNCIA ENVIANDOS COMANDOS PARA O BANCO.
		this.manager.flush();
		
		//CONFIRMA TODA TRANSAÇÃO COM O BANCO.
		this.manager.getTransaction().commit();		
	}
	
	public void alterarVeiculo(Veiculo veiculo){
		
		//INICIAR TRANSAÇÃO PARA PERSISTÊNCIA NO BANCO.
		this.manager.getTransaction().begin();
		
		//SALVAR OS DADOS QUE ESTÃO NOS OBJETOS.
		this.manager.merge(veiculo);
		
		//FAZER A PERSISTÊNCIA ENVIANDOS COMANDOS PARA O BANCO.
		this.manager.flush();
		
		//CONFIRMA TODA TRANSAÇÃO COM O BANCO.
		this.manager.getTransaction().commit();
	}
	
	public void excluirVeiculo(Veiculo veiculo){
		
		//INICIAR A TRANSAÇÃO PARA PERSISTÊNCIA NO BANCO.
		this.manager.getTransaction().begin();
		
		//FAZ A REMOÇÃO DOS DADOS.
		this.manager.remove(veiculo);
		
		//ENVIANDOS COMANDOS PARA O BANCO PARA REMOÇÃO DOS DADOS.
		this.manager.flush();
		
		//CONFIRMA TODA TRANSAÇÃO COM O BANCO.
		this.manager.getTransaction().commit();
	}
	
	public void consultarVeiculo(Veiculo veiculo){
		
		this.manager.getTransaction().begin();
				
	}

}
