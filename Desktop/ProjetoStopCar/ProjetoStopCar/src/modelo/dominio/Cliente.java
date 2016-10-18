package modelo.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "tabClientes")
public class Cliente implements CodigoSequencial, Serializable{
	
	@Id
	@GeneratedValue (generator = "COD_CLIENTE", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator (name = "COD_CLIENTE", sequenceName = "SEQ_CLIENTE", allocationSize = 1)
	private Long codCliente;
	
	@Column (length = 50, nullable = false)
	private String nome;
	
	@Column (length = 11, nullable = false, unique = true)
	private int cpf;
	
	@Column (length = 11, nullable = false)
	private String telefone;
	
	@Column (length = 7, nullable = false)
	private String placaVeiculo;
	
	public Cliente() {
		super();
	}
	
	public Cliente (String nome, int cpf, String telefone, String placaVeiculo){
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.placaVeiculo = placaVeiculo;
	}
	
	public Long getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(Long codCliente) {
		this.codCliente = codCliente;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getCpf() {
		return cpf;
	}
	
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getPlacaVeiculo() {
		return placaVeiculo;
	}
	
	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}

	@Override
	public Long getCod() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCod(Long cod) {
		// TODO Auto-generated method stub
		
	}	
}

	