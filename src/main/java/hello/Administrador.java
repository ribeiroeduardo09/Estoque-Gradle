package hello;

public class Administrador {
	
	private String login;
	private String senha;
	
	public Administrador(String login, String senha)
	{
		this.login = login;
		this.senha = senha;
	}
	
	public String getLogin()
	{
		return login;
	}
	public void setLogin(String novoLogin)
	{
		this.login = novoLogin;
	}
	
	public String getSenha()
	{
		return senha;
	}
	public void setSenha(String novaSenha)
	{
		this.senha = novaSenha;
	}
}
