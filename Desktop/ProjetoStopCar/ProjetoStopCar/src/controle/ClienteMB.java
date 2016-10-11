package controle;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import modelo.dominio.Cliente;

@ManagedBean(name="clienteMB")
@RequestScoped

//CLASSE MANAGED BEAN
public class ClienteMB {
	
	//INSTANCIA DA CLASSE CLIENTE.
	private Cliente cliente = new Cliente();
	
	//LISTA DE TODOS OS OBJETOS DA CLASSE CLIENTE.
	private ArrayList<Cliente> ListaCliente = new ArrayList<Cliente>();
	
		
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public ArrayList<Cliente> getListaCliente() {
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
	public String acaoAbrir() {
					
		return "cliente.jsf";
	}

	//SALVAR CADASTRO DE CLIENTE. 
	public void salvarCliente(Cliente cliente) {
		ListaCliente.add(cliente);
		cliente = new Cliente();
	}
	
	//CANCELAR A플O DE CADASTRO
	public String novoCliente()
	{
		return "cadastroCliente.jsf";
	}

	//CANCELAR A플O DE CADASTRO
	public String acaoCancelar()
	{
		return "cliente.jsf";
	}

	//EXCLUIR CLIENTE
	public String excluirCliente()
	{
		return "cliente.jsf";
	}
	
}
