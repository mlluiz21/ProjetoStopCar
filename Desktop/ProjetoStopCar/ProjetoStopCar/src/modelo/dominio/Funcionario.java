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
@Table (name = "tabFuncionarios")
public class Funcionario  implements CodigoSequencial, Serializable{
	
	@Id
	@GeneratedValue (generator = "ID_FUNCIONARIO", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator (name = "ID_FUNCIONARIO", sequenceName = "SEQ_FUNCIONARIO", allocationSize = 1)
	private Long id;
	
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
		
	public Funcionario(String nome, String telefone, String login, int cpf, String senha) {
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.login = login;
		this.senha = senha;
		
	}
	
	public Funcionario(){
		
		super();
	}

	public Funcionario(Object object, String string, Object object2) {
		// TODO Auto-generated constructor stub
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public boolean SenhaCorreta(String senhaDigitada){
		
		if (this.senha.equals(senhaDigitada))
			return true;
		else
		
		return false;
	}
	
	@Override
	public int hashCode()
	{
		if (this.id == null)
			return 0;

		return this.id.hashCode();
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (id == null)
		{
			if (other.id != null)
				return false;
		}
		else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return this.login;
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

