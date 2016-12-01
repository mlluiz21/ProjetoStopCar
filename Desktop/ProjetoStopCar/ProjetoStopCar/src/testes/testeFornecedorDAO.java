package testes;

import modelo.dao.FornecedorDAO;
import modelo.dominio.Fornecedor;

public class testeFornecedorDAO {

	public static void main(String[] args) {
		
		Fornecedor forne1 = new Fornecedor();
		
		forne1.setRazaoSocial("Piraque");
		forne1.setCidade("Turiaçu");
		forne1.setCnpj(30112016);
		forne1.setTelefone("2260-1361");
		
		FornecedorDAO fornedao = new FornecedorDAO();
		fornedao.incluirFornecedor(forne1);
		
		System.out.println("Fornecedor " + forne1.getRazaoSocial() + " Cadastrado com sucesso!");

	}

}
