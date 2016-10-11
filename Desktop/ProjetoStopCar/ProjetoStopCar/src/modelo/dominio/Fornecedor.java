package modelo.dominio;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tab_fornecedores")
public class Fornecedor {
	
	@Id
	private int cnpj;
	private String razaoSocial;
	private String telefone;
	private String cidade;
	
	public Fornecedor(){
		super();
	}
	
	public Fornecedor (int cnpj, String razaoSocial, String telefone, String cidade){
		super();
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
