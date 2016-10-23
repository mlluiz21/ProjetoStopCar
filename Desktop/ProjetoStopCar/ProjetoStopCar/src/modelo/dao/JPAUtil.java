package modelo.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private JPAUtil()
	{
		super();
	}

	private static EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("projetoBancoStopCar");

	public static EntityManagerFactory getFabrica() 
	{
		return fabrica;
	}

	public static EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return null;
	}

}
