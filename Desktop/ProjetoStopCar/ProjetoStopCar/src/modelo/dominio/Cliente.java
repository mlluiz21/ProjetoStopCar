package modelo.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tabClientes")
public class Cliente {
	
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
}

	