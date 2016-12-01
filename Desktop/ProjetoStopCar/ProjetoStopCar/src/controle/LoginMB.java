package controle;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import modelo.dao.FuncionarioDAO;
import modelo.dominio.Funcionario;
import controle.Util.JSFUtil;

@ManagedBean(name = "loginMB")
@SessionScoped
public class LoginMB implements Serializable
{
	private static final long serialVersionUID = 1L;

	private boolean autenticado = false;
	private Funcionario funcionario = new Funcionario(null, "(não autenticado)", null);

	private String login;
	private String senha;

	public Funcionario getFuncionario()
	{
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario)
	{
		this.funcionario = funcionario;
	}

	public boolean isAutenticado()
	{
		return autenticado;
	}

	public String getLogin()
	{
		return login;
	}

	public void setLogin(String login)
	{
		this.login = login;
	}

	public String getSenha()
	{
		return senha;
	}

	public void setSenha(String senha)
	{
		this.senha = senha;
	}

	/**
	 * 
	 */
	public String acaoAbrirLogin()
	{
		return "login";
	}

	/**
	 * 
	 */
	public String acaoAutenticar()
	{
		FuncionarioDAO dao = new FuncionarioDAO();

		Funcionario funcionarioDoBanco = dao.lerPorLogin(this.getLogin());

		if (funcionarioDoBanco == null)
		{
			JSFUtil.retornarMensagemErro("Usuário não existe.", null, null);
			return "login";
		}
		else if (funcionarioDoBanco.SenhaCorreta(this.senha))
		
		{
			// guardar o obteto usuário
			this.setFuncionario(funcionarioDoBanco);
			this.autenticado = true;

			return "paginaHome";
		}
		else
		{
			JSFUtil.retornarMensagemErro("Senha inválida.", null, null);
			return "login";
		}
	}

	/**
	 * 
	 */
	public String acaoLogout()
	{
		this.funcionario = new Funcionario(null, "(não autenticado)", null);
		this.autenticado = false;
		this.login = null;
		this.senha = null;

		// encerrar a sessão atual
		JSFUtil.getHttpSession().invalidate();

		return "login";
	}

}
