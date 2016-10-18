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
@Table(name = "tabFornecedores")
public class Fornecedor implements CodigoSequencial, Serializable{
	
	@Id
	@GeneratedValue (generator = "COD_FORNECEDOR", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator (name = "COD_FORNECEDOR", sequenceName = "SEQ_FORNECEDOR", allocationSize = 1)
	private Long codFornecedor;
	
	@Column (length = 14, nullable = false, unique = true)
	private int cnpj;
	
	@Column (length = 70, nullable = false)
	private String razaoSocial;
	
	@Column (length = 14, nullable = false)
	private String telefone;
	
	@Column (length = 40, nullable = false)
	private String cidade;
	
	public Fornecedor(){
		super();
	}
	
	public Fornecedor (int cnpj, String razaoSocial, String telefone, String cidade){
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.telefone = telefone;
		this.cidade = cidade;
	}
		
	public Long getCodFornecedor() {
		return codFornecedor;
	}

	public void setCodFornecedor(Long codFornecedor) {
		this.codFornecedor = codFornecedor;
	}

	public int getCnpj() {
		return cnpj;
	}

	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
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
