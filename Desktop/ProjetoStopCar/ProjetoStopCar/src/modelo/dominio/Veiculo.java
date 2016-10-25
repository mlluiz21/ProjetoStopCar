package modelo.dominio;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table (name = "tabVeiculo")
public class Veiculo implements CodigoSequencial, Serializable{
	
	@Id
	@GeneratedValue (generator = "COD_VEICULO", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator (name = "COD_VEICULO", sequenceName = "SEQ_VEICULO", allocationSize = 1)
	private int codVeiculo;
	
	@Column (length = 7, nullable = false, unique = true)
	private String placa;
	
	@Column (length = 20, nullable = false)
	private String modelo;
	
	@Column (length = 30, nullable = false)
	private String cor;
	
	@OneToOne (cascade = CascadeType.ALL, optional = true, orphanRemoval = true)
	private Cliente cliente;
	
	@OneToOne
	private Funcionario funcionario;
	
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
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
