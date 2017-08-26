package hello;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Compra {
	
	private Float valortotal;
	private LocalDate datacompra;
	private List<Produto> produtos = new LinkedList<Produto>();
	private List<Fornecedor> fornecedores = new LinkedList<Fornecedor>();
	private int codigocompra;
	
	public Compra(Float valortotal, LocalDate datacompra, List<Produto> produtos, List<Fornecedor> fornecedores, int codigocompra)
	{
		this.valortotal = valortotal;
		this.datacompra = datacompra;
		this.produtos = produtos;
		this.fornecedores = fornecedores;
		this.codigocompra = codigocompra;
	}

	//Valor Total
	public Float getValortotal()
	{
		return valortotal;
	}

	public void setValortotal(Float valortotal)
	{
		this.valortotal = valortotal;
	}

	//Data da Compra
	public LocalDate getDatacompra()
	{
		return datacompra;
	}

	public void setDatacompra(LocalDate datacompra)
	{
		this.datacompra = datacompra;
	}

	//Produtos
	public List<Produto> getProdutos()
	{
		return produtos;
	}
	public void setProdutos(List<Produto> produtos)
	{
		this.produtos = produtos;
	}
	public void addProduto(Produto prod)
	{
		produtos.add(prod);
	}
	public void delProduto(int codigoproduto)
	{
		for(Produto prod:produtos)
		{
			if(prod.getCodigoproduto() == codigoproduto)
				produtos.remove(prod);
		}
	}

	//Fornecedores
	public List<Fornecedor> getFornecedores()
	{
		return fornecedores;
	}
	public void setFornecedores(List<Fornecedor> fornecedores)
	{
		this.fornecedores = fornecedores;
	}
	public void addFornecedor(Fornecedor fornec)
	{
		fornecedores.add(fornec);
	}
	public void delFornecedor(int cnpj)
	{
		for(Fornecedor temp:fornecedores)
		{
			if(temp.getCnpj() == cnpj)
				fornecedores.remove(temp);
		}
	}

	//Código da Compra
	public int getCodigocompra() {
		return codigocompra;
	}
	public void setCodigocompra(int codigocompra) {
		this.codigocompra = codigocompra;
	}
	
}
