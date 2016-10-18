package modelo.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "tabVeiculo")
public class Veiculo {
	
	
	private int codVeiculo;
	
	@Column (length = 7, nullable = false, unique = true)
	private String placa;
	
	@Column (length = 20, nullable = false)
	private String modelo;
	
	@Column (length = 30, nullable = false)
	private String cor;
	
	public Veiculo(int codVeiculo, String placa, String modelo, String cor) {
		this.codVeiculo = codVeiculo;
		this.placa = placa;
		this.modelo = modelo;
		this.cor = cor;
	}

	public int getCodVeiculo() {
		return codVeiculo;
	}

	public void setCodVeiculo(int codVeiculo) {
		this.codVeiculo = codVeiculo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
	
	
}
