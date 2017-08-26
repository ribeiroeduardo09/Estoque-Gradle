package hello;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Fornecedor {
	private String nomeFornecedor;
	private int cnpj;
	private String email;
	private String telefone;
	private String endereco;
	private LocalDate datacadastroforn;
	private List<Produto> produtos = new LinkedList<Produto>();
	
	public Fornecedor(String nomeFornecedor, int cnpj, String email, String telefone, String endereco, 
					  LocalDate datacadastroforn, List<Produto> produtos)
	{
		this.nomeFornecedor = nomeFornecedor;
		this.cnpj = cnpj;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
		this.datacadastroforn = datacadastroforn;
		this.produtos = produtos;
	}
	
	public String getNome()
	{
		return nomeFornecedor;
	}
	public void setNome(String nomeFornecedor)
	{
		this.nomeFornecedor = nomeFornecedor;
	}
	
	public int getCnpj()
	{
		return cnpj;
	}
	public void setCnpj(int cnpj)
	{
		this.cnpj = cnpj;
	}
	
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	
	public String getTelefone()
	{
		return telefone;
	}
	public void setTelefone(String telefone)
	{
		this.telefone = telefone;
	}
	
	public String getEndereco()
	{
		return endereco;
	}
	public void setEndereco(String endereco)
	{
		this.endereco = endereco;
	}
	
	public LocalDate getDatacadastroforn()
	{
		return datacadastroforn;
	}
	public void setDatacadastroforn(LocalDate datacadastroforn)
	{
		this.datacadastroforn = datacadastroforn;
	}
		
	public void addProduto(Produto prod)
	{
		produtos.add(prod);
	}
	public void delProduto(int codigoproduto)
	{
		for(Produto temp:produtos)
		{
			if(temp.getCodigoproduto() == codigoproduto)
				produtos.remove(temp);
		}
	}
	public List<Produto> getProdutos()
	{
		return produtos;
	}
	public void setProdutos(List<Produto> novosProdutos)
	{
		this.produtos = novosProdutos;
	}
}