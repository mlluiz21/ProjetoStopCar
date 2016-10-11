package modelo.dominio;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tab_clientes")
public class Cliente {
	
	@Id
	private String nome;
	private int cpf;
	private String telefone;
	private String placaVeiculo;
	
	public Cliente() {
		super();
	}
	
	public Cliente (String nome, int cpf, String telefone, String placaVeiculo){
		super();
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

	