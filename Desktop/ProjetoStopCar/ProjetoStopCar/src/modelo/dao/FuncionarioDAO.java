package modelo.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import controle.Util.JPAUtil;
import modelo.dominio.Funcionario;

public class FuncionarioDAO {
	
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
		
		//INICIAR TRANSA��O PARA PERSIST�NCIA NO BANCO.
		this.manager.getTransaction().begin();
		
		//SALVAR OS DADOS QUE EST�O NOS OBJETOS.
		this.manager.merge(funcionario);
		
		//FAZER A PERSIST�NCIA ENVIANDOS COMANDOS PARA O BANCO.
		this.manager.flush();
		
		//CONFIRMA TODA TRANSA��O COM O BANCO.
		this.manager.getTransaction().commit();		
	}
	
	public void alterarFuncionario(Funcionario funcionario){
		
		//INICIAR TRANSA��O PARA PERSIST�NCIA NO BANCO.
		this.manager.getTransaction().begin();
		
		//SALVAR OS DADOS QUE EST�O NOS OBJETOS.
		this.manager.merge(funcionario);
		
		//FAZER A PERSIST�NCIA ENVIANDOS COMANDOS PARA O BANCO.
		this.manager.flush();
		
		//CONFIRMA TODA TRANSA��O COM O BANCO.
		this.manager.getTransaction().commit();
	}
	
	public void excluirFuncionario(Funcionario funcionario){
		
		//INICIAR A TRANSA��O PARA PERSIST�NCIA NO BANCO.
		this.manager.getTransaction().begin();
		
		//FAZ A REMO��O DOS DADOS.
		this.manager.remove(funcionario);
		
		//ENVIANDOS COMANDOS PARA O BANCO PARA REMO��O DOS DADOS.
		this.manager.flush();
		
		//CONFIRMA TODA TRANSA��O COM O BANCO.
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

}