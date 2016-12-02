package controle;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import modelo.dao.ClienteDAO;
import modelo.dominio.Cliente;
import controle.Util.JSFUtil;

@ManagedBean(name="clienteMB")
@RequestScoped

//CLASSE MANAGED BEAN
public class ClienteMB {
	
	//INSTANCIA DA CLASSE CLIENTE.
	Cliente cliente = new Cliente();
	
	//INSTANCIA DA CLASSE CLIENTEDAO.
	ClienteDAO clientedao = new ClienteDAO();
	
	//LISTA DE TODOS OS OBJETOS DA CLASSE CLIENTE.
	private List<Cliente> listaCliente = null;
	
		
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public List<Cliente> getListaCliente() {
		
		if(this.listaCliente == null){
			this.listaCliente = this.clientedao.lerTodos();
		}
		return listaCliente;
	}

	public void setListaCliente(List<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}
	
	public void setClienteDAO(ClienteDAO clientedao){
		this.clientedao = clientedao;
	}
	
	//ACESSAR PÁGINA DE CADASTRO CLIENTES***********************************************.
	
	public String cadastrarCliente() {
		
		cliente.getCpf();
		cliente.getNome();
		cliente.getPlacaVeiculo();
		cliente.getTelefone();
		
		clientedao.salvar(this.cliente);
		
		return "clienteEditar.jsf";
		
	}//*********************************************************************************
	
	//ABRIR EDIÇÃO DE CADASTRO DE CLIENTE***********************************************.
	
	public String alterarCliente() {
		
		Long codcliente = JSFUtil.getParametroLong("codcliente");
		Cliente alterarcliente = this.clientedao.lerPorId(codcliente);
		this.setCliente(alterarcliente);
		this.clientedao.salvar(alterarcliente);
		
		return "clienteEditar.jsf";
		
	}//*********************************************************************************

	//SALVAR CADASTRO DE CLIENTE********************************************************. 
	
	public String salvarCliente() {

			if ((this.getCliente().getCodCliente() != null)
					&& (this.getCliente().getCodCliente().longValue() == 0))
				this.getCliente().setCodCliente(null);

			this.clientedao.salvar(this.getCliente());
			// limpa a lista
			this.cliente = null;
			
			// limpar o objeto da página
			this.setCliente(new Cliente());
			
			return "paginaHome.jsf";
			
	}//*********************************************************************************
	
	//CANCELAR AÇÃO DE CADASTRO*********************************************************
	
	public String novoCliente()
	{
		this.setCliente(new Cliente());
		
		return "clienteEditar.jsf";
		
	}//*********************************************************************************

	//CANCELAR AÇÃO DE CADASTRO
	
	public String acaoCancelar()
	{
		this.setCliente(new Cliente());
		
		return "paginaHome.jsf";
	}

	//EXCLUIR CLIENTE******************************************************************
	
	public String excluirCliente()
	{
		int cpf = JSFUtil.getParametroInteger("cpf");
		Cliente clienteBanco = this.clientedao.lerPorCpf(cpf);
		clientedao.excluir(clienteBanco);

		this.setCliente(new Cliente());
		this.cliente = null;
		
		return "paginaHome.jsf";
		
	}//********************************************************************************
	
}
