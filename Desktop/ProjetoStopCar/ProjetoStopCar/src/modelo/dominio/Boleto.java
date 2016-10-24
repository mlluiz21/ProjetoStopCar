package modelo.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table (name = "tabBoleto")
public class Boleto implements CodigoSequencial, Serializable {
	
	@Id
	@GeneratedValue(generator = "COD_BOLETO", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator (name = "COD_BOLETO", sequenceName = "SEQ_BOLETO", allocationSize = 1)
	private Long codBoleto;
	
	@Column (length = 50, nullable = false)
	private String nomeCliente;
	
	@Column (length = 6, nullable = false)
	private float valor;
	
	@OneToOne
	@JoinColumn(nullable = false)
	private Servico servico;
	
	public Boleto (Long codBoleto, String nomeCliente, float valor){
		this.codBoleto = codBoleto;
		this.nomeCliente = nomeCliente;
		this.valor = valor;
	}

	public Long getCodBoleto() {
		return codBoleto;
	}

	public void setCodBoleto(Long codBoleto) {
		this.codBoleto = codBoleto;
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
	
	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
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
