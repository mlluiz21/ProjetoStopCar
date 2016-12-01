package modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.dominio.Funcionario;
import controle.Util.JPAUtil;
import controle.Util.JpaDAO;

public class FuncionarioDAO extends JpaDAO<Funcionario>{
	
private EntityManager manager = null;
	
	public FuncionarioDAO(){
		
		this.manager = JPAUtil.getEntityManager();
	}
	
	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void incluirFuncionario(Funcionario funcionario){
		
		//INICIAR TRANSAÇÃO PARA PERSISTÊNCIA NO BANCO.
		this.manager.getTransaction().begin();
		
		//SALVAR OS DADOS QUE ESTÃO NOS OBJETOS.
		this.manager.merge(funcionario);
		
		//FAZER A PERSISTÊNCIA ENVIANDOS COMANDOS PARA O BANCO.
		this.manager.flush();
		
		//CONFIRMA TODA TRANSAÇÃO COM O BANCO.
		this.manager.getTransaction().commit();		
	}
	
	public void alterarFuncionario(Funcionario funcionario){
		
		//INICIAR TRANSAÇÃO PARA PERSISTÊNCIA NO BANCO.
		this.manager.getTransaction().begin();
		
		//SALVAR OS DADOS QUE ESTÃO NOS OBJETOS.
		this.manager.merge(funcionario);
		
		//FAZER A PERSISTÊNCIA ENVIANDOS COMANDOS PARA O BANCO.
		this.manager.flush();
		
		//CONFIRMA TODA TRANSAÇÃO COM O BANCO.
		this.manager.getTransaction().commit();
	}
	
	public void excluirFuncionario(Funcionario funcionario){
		
		//INICIAR A TRANSAÇÃO PARA PERSISTÊNCIA NO BANCO.
		this.manager.getTransaction().begin();
		
		//FAZ A REMOÇÃO DOS DADOS.
		this.manager.remove(funcionario);
		
		//ENVIANDOS COMANDOS PARA O BANCO PARA REMOÇÃO DOS DADOS.
		this.manager.flush();
		
		//CONFIRMA TODA TRANSAÇÃO COM O BANCO.
		this.manager.getTransaction().commit();
	}
	
	public void consultarFuncionario(Funcionario funcionario){
		
		this.manager.getTransaction().begin();
				
	}

	public Funcionario lerPorLogin(String login)
	{
		Funcionario resultado;

		Query consulta = this.getManager().createQuery("from Usuario u where u.login = :login");
		consulta.setParameter("login", login);

		try
		{
			resultado = (Funcionario) consulta.getSingleResult();
		}
		catch (NoResultException e)
		{
			resultado = null;
		}

		return resultado;
	}
	
		@SuppressWarnings("unchecked")
		public List<Funcionario> consultarFuncionario(){
		
		List<Funcionario> resultadoBusca;
		
		Query consulta = this.getManager().createQuery("from tabFuncionario f order by nome");
		
		try
		{
			resultadoBusca = (List<Funcionario>) consulta.getResultList();
		}
		
		catch (NoResultException e)
		{
			resultadoBusca = null;
		}
		
		return resultadoBusca;
				
	}

}