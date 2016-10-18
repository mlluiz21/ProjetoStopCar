package modelo.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "tabFuncionarios")
public class Funcionario {
	
	@Column (length = 11, nullable = false, unique = true)
	private int cpf;
	
	@Column (length = 50, nullable = false)
	private String nome;
	
	@Column (length = 11, nullable = false)
	private String telefone;
	
	@Column (length = 25, nullable = false, unique = true)
	private String login;
	
	@Column (length = 25, nullable = false)
	private String senha;
		
	public Funcionario(int cpf, String nome, String telefone, String login, String senha) {
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.login = login;
		this.senha = senha;
		
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isSenhaCorreta(String senhaDigitada){
		if (this.senha.equals(senhaDigitada))
			return true;
		
		return false;
	}
}
