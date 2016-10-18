package modelo.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tabFornecedores")
public class Fornecedor {
	
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
}
