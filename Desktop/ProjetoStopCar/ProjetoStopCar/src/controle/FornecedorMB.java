package controle;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import controle.Util.JSFUtil;
import modelo.dao.FornecedorDAO;
import modelo.dominio.Fornecedor;

@ManagedBean(name="fornecedorMB")
@RequestScoped
public class FornecedorMB {
	
	
	Fornecedor fornecedor = new Fornecedor();
	FornecedorDAO fornecedordao = new FornecedorDAO();
	
	private List<Fornecedor> ListaFornecedores = null;
	
	public Fornecedor getFornecedor() {
		return fornecedor;
	}


	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	public List<Fornecedor> getListaFornecedor() {
		
		if(this.ListaFornecedores == null){
			this.ListaFornecedores = this.fornecedordao.lerTodos();
		}
		return ListaFornecedores;
	}

	public void setListaFornecedor(List<Fornecedor> listaFornecedor) {
		this.ListaFornecedores = listaFornecedor;
	}
	
	
	//ACESSAR PÁGINA COM A LISTA DE TODOS OS FORNECEDORES.
	public String acaoListar() {
		
		return "listarFornecedor.jsf";
	}
	
	//ABRIR EDIÇÃO DE CADASTRO DE FORNECEDOR.
	public String acaoAbrir() {
					
		return "fornecedor.jsf";
	}

	//SALVAR CADASTRO DE FORNECEDOR ********************************. 
	public String salvarFornecedor() {
		
		if ((this.getFornecedor().getCod() != null) && (this.getFornecedor().getCod().longValue() == 0))
			this.getFornecedor().setCod(null);
		
		this.fornecedordao.salvar(this.getFornecedor());
		this.fornecedor = null;
		this.setFornecedor(new Fornecedor());
		
		return "paginaHome.jsf";
	} //**********************************************************
	
	
	public String novoFornecedor()
	{
		this.setFornecedor(new Fornecedor());
		
		return "fornecedorEditar.jsf";
	}

	//CANCELAR AÇÃO DE CADASTRO
	public String acaoCancelar()
	{
		return "paginaHome.jsf";
	}

	//EXCLUIR FORNECEDOR **********************************************
	public String excluirFornecedor()
	{
		long codFornecedor = JSFUtil.getParametroLong("codFornecedor");
		Fornecedor fornecedorBanco = this.fornecedordao.lerPorCodigo(codFornecedor);
		this.fornecedordao.excluir(fornecedorBanco);

		this.setFornecedor(new Fornecedor());
		this.fornecedor = null;

		return "paginaHome.jsf";
		
	} //*************************************************************
	
}
