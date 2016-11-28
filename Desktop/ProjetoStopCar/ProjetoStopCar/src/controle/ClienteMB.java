package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import modelo.dao.ClienteDAO;
import modelo.dominio.Cliente;

@ManagedBean(name="clienteMB")
@RequestScoped

//CLASSE MANAGED BEAN
public class ClienteMB {
	
	//INSTANCIA DA CLASSE CLIENTE.
	private Cliente cliente = new Cliente();
	
	//INSTANCIA DA CLASSE CLIENTEDAO.
	@SuppressWarnings("unused")
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
	
	//ACESSAR P핯INA COM A LISTA DE TODOS OS CLIENTES.
	public String acaoListar() {
		
		return "listarCliente.jsf";
	}
	
	//ABRIR EDI플O DE CADASTRO DE CLIENTE.
	public String acaoAbrirAlteracao() {
					
		this.setCliente(new Cliente());
		
		return "clienteEditar";
	}

	//SALVAR CADASTRO DE CLIENTE. 
	public void salvarCliente(Cliente cliente) {
		ListaCliente.add(cliente);
		cliente = new Cliente();
	}
	
	//CANCELAR A플O DE CADASTRO
	public String novoCliente()
	{
		this.setCliente(new Cliente());
		
		return "clienteEditar";
	}

	//CANCELAR A플O DE CADASTRO
	public String acaoCancelar()
	{
		return "paginaHome";
	}

	//EXCLUIR CLIENTE
	public String excluirCliente()
	{
		return "cliente.jsf";
	}
	
}
