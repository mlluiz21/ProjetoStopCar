package testes;

import modelo.dao.FuncionarioDAO;
import modelo.dominio.Funcionario;

public class testeFuncionarioDAO {
	
	public static void main(String[] args) {
		
		Funcionario func1 = new Funcionario();
		
		func1.setNome("Luiz");
		func1.setCpf(053774);
		func1.setTelefone("99405-1983");
		func1.setLogin("luiz");
		func1.setSenha("053");
		
		FuncionarioDAO funcdao = new FuncionarioDAO();
		funcdao.incluirFuncionario(func1);
		
		System.out.println("Funcionário " + func1.getNome() + " Cadastrado com sucesso!");
		
	}

}
