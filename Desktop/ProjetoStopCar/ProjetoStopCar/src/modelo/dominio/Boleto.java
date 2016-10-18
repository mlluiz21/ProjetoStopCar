package modelo.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "tabBoleto")
public class Boleto {
	
	
	private int numBoleto;
	
	@Column (length = 50, nullable = false)
	private String nomeCliente;
	
	@Column (length = 6, nullable = false)
	private float valor;
	
	public Boleto (int numBoleto, String nomeCliente, float valor){
		this.numBoleto = numBoleto;
		this.nomeCliente = nomeCliente;
		this.valor = valor;
	}

	public int getNumBoleto() {
		return numBoleto;
	}

	public void setNumBoleto(int numBoleto) {
		this.numBoleto = numBoleto;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
	
}
