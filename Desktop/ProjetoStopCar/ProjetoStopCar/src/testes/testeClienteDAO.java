package testes;

import modelo.dao.ClienteDAO;
import modelo.dominio.Cliente;

public class testeClienteDAO {

	public static void main(String[] args) {
		
		Cliente c1 = new Cliente();
		
		c1.setNome("Marcelo");
		c1.setCpf(222222222);
		c1.setTelefone("2277883344");
		c1.setPlacaVeiculo("TSE1036");
		
		ClienteDAO dao = new ClienteDAO();
		dao.incluirCliente(c1);
		
		System.out.println("Cliente " + c1.getNome() + " Cadastrado com sucesso!");

	}

}