package controle;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import modelo.dominio.Fornecedor;

@ManagedBean(name="fornecedorMB")
@RequestScoped
public class FornecedorMB {
	
	
	private Fornecedor fornecedor = new Fornecedor();
	private ArrayList<Fornecedor> ListaFornecedores = new ArrayList<Fornecedor>();
	
	public Fornecedor getFornecedor() {
		return fornecedor;
	}


	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	public ArrayList<Fornecedor> getListaFornecedor() {
		return ListaFornecedores;
	}

	public void setListaFornecedor(ArrayList<Fornecedor> listaFornecedor) {
		this.ListaFornecedores = listaFornecedor;
	}
	
	//ACESSAR P핯INA COM A LISTA DE TODOS OS CLIENTES.
	public String acaoListar() {
		
		return "listarFornecedor.jsf";
	}
	
	//ABRIR EDI플O DE CADASTRO DE CLIENTE.
	public String acaoAbrir() {
					
		return "fornecedor.jsf";
	}

	//SALVAR CADASTRO DE CLIENTE. 
	public void salvarFornecedor(Fornecedor fornecedor) {
		ListaFornecedores.add(fornecedor);
		fornecedor = new Fornecedor();
	}
	
	//CANCELAR A플O DE CADASTRO
	public String novoFornecedor()
	{
		return "cadastroFornecedor.jsf";
	}

	//CANCELAR A플O DE CADASTRO
	public String acaoCancelar()
	{
		return "fornecedor.jsf";
	}

	//EXCLUIR CLIENTE
	public String excluirFornecedor()
	{
		return "fornecedor.jsf";
	}
	
}
