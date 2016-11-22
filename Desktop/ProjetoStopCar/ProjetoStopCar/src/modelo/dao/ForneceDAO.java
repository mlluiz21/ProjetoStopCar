package modelo.dao;

import javax.persistence.EntityManager;

public class ForneceDAO {
	
	private EntityManager manager = null;
	
	public ForneceDAO(){
		
		this.manager = JPAUtil.getEntityManager();
	}

	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}
	
	
}
