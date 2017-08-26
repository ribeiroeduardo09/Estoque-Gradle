package hello;

import java.util.LinkedList;
import java.util.List;

public class Sistema {
	
	private List<Produto> produtos = new LinkedList<Produto>();
	private List<Cliente> clientes = new LinkedList<Cliente>();
	private List<Fornecedor> fornecedores = new LinkedList<Fornecedor>();
	private List<Usuario> usuarios = new LinkedList<Usuario>();
	private List<Venda> vendas = new LinkedList<Venda>();
	private List<Compra> compras = new LinkedList<Compra>();
	
	/*---------Produtos----------*/
	public void addProduto(Produto prod){
		produtos.add(prod);
	}
	public void delProduto(int codigoproduto){
		for(Produto prod:produtos){
			if(prod.getCodigoproduto()==codigoproduto) produtos.remove(prod);
		}
	}
	public Produto searchProduto(int codigoproduto){
		for(Produto prod:produtos){
			if(prod.getCodigoproduto() == codigoproduto) return prod;
		} 
		return null;
	}/*---------Usuários----------*/
	public void addUsuario(Usuario usuario){
		usuarios.add(usuario);
	}
	public void delUsuario(String login){
		for(Usuario usr:usuarios){
			if(usr.getLogin()==login) usuarios.remove(usr);
		}
	}
	public Usuario searchUsuario(String login){
		for(Usuario usr:usuarios){
			if(usr.getLogin().equals(login)) return usr;
		}
		return null;
	}
	/*---------Clientes----------*/
	public void addCliente(Cliente cliente){
		clientes.add(cliente);
	}
	public void delCliente(int codigocliente){
		for(Cliente cli:clientes){
			if(cli.getCodigocliente()==codigocliente) clientes.remove(cli);
		}
	}
	public Cliente searchCliente(int codigocliente){
		for(Cliente cli:clientes){
			if(cli.getCodigocliente()==codigocliente) return cli;
		}
		return null;
	}
	/*---------Fornecedores----------*/
	public void addFornecedor(Fornecedor fornecedor){
		fornecedores.add(fornecedor);
	}
	public void delFornecedor(int cnpj){
		for(Fornecedor fncdr:fornecedores){
			if(fncdr.getCnpj()==cnpj) fornecedores.remove(fncdr);
		}
	}
	public Fornecedor searchFornecedor(int cnpj){
		for(Fornecedor fncdr:fornecedores){
			if(fncdr.getCnpj()==cnpj) return fncdr;
		}
		return null;
	}
	/*---------Compras----------*/
	public void addCompra(Compra compra){
		compras.add(compra);
	}
	public void delCompra(int codigocompra){
		for(Compra comp:compras){
			if(comp.getCodigocompra()==codigocompra) compras.remove(comp);
		}
	}
	public Compra searchCompra(int codigocompra){
		for(Compra comp:compras){
			if(comp.getCodigocompra()==codigocompra) return comp;
		}
		return null;
	}
	/*---------Venda----------*/
	public void addVenda(Venda venda){
		vendas.add(venda);
	}
	public void delVenda(int codigo){
		for(Venda ven:vendas){
			if(ven.getCodigo()==codigo) vendas.remove(ven);
		}
	}
	public Venda searchVenda(int codigo){
		for(Venda ven:vendas){
			if(ven.getCodigo()==codigo) return ven;
		}
		return null;
	}
	
	//Getters & Setters
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	public List<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}
	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	public List<Venda> getVendas() {
		return vendas;
	}
	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}
	public List<Compra> getCompras() {
		return compras;
	}
	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

}
