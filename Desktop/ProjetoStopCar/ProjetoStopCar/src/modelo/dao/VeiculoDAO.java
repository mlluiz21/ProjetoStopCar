package modelo.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.dominio.Veiculo;

public class VeiculoDAO {
	
	private EntityManager manager = null;
	
	public VeiculoDAO(){
		
		super();
		
		EntityManagerFactory criandoMinhaFabrica = Persistence.createEntityManagerFactory("ProjetoBancoStopCar");
		
		this.manager = criandoMinhaFabrica.createEntityManager();
	}
	
	public void incluirVeiculo(Veiculo veiculo){
		
		this.manager.getTransaction().begin();
		
		
	}

}
