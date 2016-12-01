package modelo.dao;

import javax.persistence.EntityManager;

import controle.Util.JPAUtil;

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
