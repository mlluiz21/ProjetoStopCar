package controle;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import modelo.dao.FornecedorDAO;
import modelo.dominio.Fornecedor;

@ManagedBean(name="fornecedorMB")
@RequestScoped
public class FornecedorMB {
	
	
	Fornecedor fornecedor = new Fornecedor();
	FornecedorDAO fornecedordao = new FornecedorDAO();
	
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
	public String salvarFornecedor() {
		
		if ((this.getFornecedor().getCod() != null) && (this.getFornecedor().getCod().longValue() == 0))
			this.getFornecedor().setCod(null);
		
		this.fornecedordao.salvar(this.getFornecedor());
		this.fornecedor = null;
		this.setFornecedor(new Fornecedor());
		
		return "paginaHome.jsf";
	}
	
	//CANCELAR A플O DE CADASTRO
	public String novoFornecedor()
	{
		this.setFornecedor(new Fornecedor());
		
		return "fornecedorEditar.jsf";
	}

	//CANCELAR A플O DE CADASTRO
	public String acaoCancelar()
	{
		return "paginaHome.jsf";
	}

	//EXCLUIR CLIENTE
	public String excluirFornecedor()
	{
		return "fornecedorEditar.jsf";
	}
	
}
