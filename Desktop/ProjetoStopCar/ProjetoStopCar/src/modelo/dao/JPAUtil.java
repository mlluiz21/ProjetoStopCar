package modelo.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory criandoMinhaFabrica = null;
	
	static
	{
		criandoMinhaFabrica = Persistence.createEntityManagerFactory("ProjetoBancoStopCar");
	}
	
	public static EntityManager getEntityManager()
	{
		return criandoMinhaFabrica.createEntityManager();
	}
	
	private JPAUtil()
	{
		super();
	}
	
}



