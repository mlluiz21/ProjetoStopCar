package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import controle.Util.JSFUtil;
import modelo.dao.ClienteDAO;
import modelo.dominio.Cliente;

@ManagedBean(name="clienteMB")
@RequestScoped

//CLASSE MANAGED BEAN
public class ClienteMB {
	
	//INSTANCIA DA CLASSE CLIENTE.
	private Cliente cliente = new Cliente();
	
	//INSTANCIA DA CLASSE CLIENTEDAO.
	private ClienteDAO clientedao = new ClienteDAO();
	
	//LISTA DE TODOS OS OBJETOS DA CLASSE CLIENTE.
	private List<Cliente> ListaCliente = null;
	
		
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public List<Cliente> getListaCliente() {
		return ListaCliente;
	}

	public void setListaCliente(ArrayList<Cliente> listaCliente) {
		this.ListaCliente = listaCliente;
	}
	
	//ACESSAR PÁGINA COM A LISTA DE TODOS OS CLIENTES.
	public String acaoListar() {
		
		return "listarCliente.jsf";
	}
	
	//ABRIR EDIÇÃO DE CADASTRO DE CLIENTE.
	public String acaoAbrirAlteracao() {
					
		this.setCliente(new Cliente());
		
		return "clienteEditar.jsf";
	}

	//SALVAR CADASTRO DE CLIENTE. 
	public String salvarCliente() {

			if ((this.getCliente().getCodCliente() != null)
					&& (this.getCliente().getCodCliente().longValue() == 0))
				this.getCliente().setCodCliente(null);

			this.clientedao.incluirCliente(this.getCliente());
			// limpa a lista
			this.cliente = null;
			
			// limpar o objeto da página
			this.setCliente(new Cliente());
			
			return this.acaoListar();

	}
	
	//CANCELAR AÇÃO DE CADASTRO
	public String novoCliente()
	{
		this.setCliente(new Cliente());
		
		return "clienteEditar.jsf";
	}

	//CANCELAR AÇÃO DE CADASTRO
	public String acaoCancelar()
	{
		this.setCliente(new Cliente());
		
		return "paginaHome.jsf";
	}

	//EXCLUIR CLIENTE
	public String excluirCliente()
	{
		int cpf = JSFUtil.getParametroInteger("cpf");
		Cliente clienteBanco = this.clientedao.lerPorCpf(cpf);
		clientedao.excluirCliente(clienteBanco);

		this.setCliente(new Cliente());
		this.cliente = null;
		
		return "paginaHome.jsf";
	}
	
}
