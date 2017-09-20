package hello;

import java.util.LinkedList;
import java.util.List;

public class Sistema {
	
	private List<Produto> produtos = new LinkedList<Produto>();
	private List<Fornecedor> fornecedores = new LinkedList<Fornecedor>();
	private List<Usuario> usuarios = new LinkedList<Usuario>();
	private List<Compra> compras = new LinkedList<Compra>();
	
	/*---------Produtos----------*/
	public void addProduto(Produto prod){
		produtos.add(prod);
	}
	public void delProduto(int codigoproduto){
		for(Produto prod:produtos){
			if(prod.getCodigoproduto()==codigoproduto)
				produtos.remove(prod);
		}
	}
	public Produto searchProduto(int codigoproduto){
		for(Produto prod:produtos){
			if(prod.getCodigoproduto() == codigoproduto)
				return prod;
		} 
		return null;
	}
	/*---------Fornecedores----------*/
	public void addFornecedor(Fornecedor fornecedor){
		fornecedores.add(fornecedor);
	}
	public void delFornecedor(int cnpj){
		for(Fornecedor fncdr:fornecedores){
			if(fncdr.getCnpj()==cnpj)
				fornecedores.remove(fncdr);
		}
	}
	public Fornecedor searchFornecedor(int cnpj){
		for(Fornecedor fncdr:fornecedores){
			if(fncdr.getCnpj()==cnpj)
				return fncdr;
		}
		return null;
	}
	public LinkedList<Produto> searchFornecedorListP(int cnpj){
		LinkedList<Produto> lTemp = new LinkedList<Produto>();
		Fornecedor forn = null;
		for(Fornecedor tempForn:fornecedores){
				if(tempForn.getCnpj() == cnpj)
					forn = tempForn;
		}
		for(Produto tempProd:produtos){
			for(Produto tempProd2:forn.getProdutos()){
				if(tempProd.getCodigoproduto() == tempProd2.getCodigoproduto())
					lTemp.add(tempProd);
			}
		}
		return lTemp;
	}
	/*---------Compras----------*/
	public void addCompra(Compra compra){
		compras.add(compra);
	}
	public void delCompra(int codigocompra){
		for(Compra comp:compras){
			if(comp.getCodigocompra()==codigocompra)
				compras.remove(comp);
		}
	}
	public Compra searchCompra(int codigocompra){
		for(Compra comp:compras){
			if(comp.getCodigocompra()==codigocompra)
				return comp;
		}
		return null;
	}
	/*---------Usuários----------*/
	public void addUsuario(Usuario usuario){
		usuarios.add(usuario);
	}
	public void delUsuario(String login){
		for(Usuario usr:usuarios){
			if(usr.getLogin().equals(login))
				usuarios.remove(usr);
		}
	}
	public Usuario searchUsuario(String login){
		for(Usuario usr:usuarios){
			if(usr.getLogin().equals(login))
				return usr;
		}
		return null;
	}
	public boolean logarUsuario(String login, String senha){
		for(Usuario usr:usuarios){
			if(usr.getLogin().equals(login) && usr.getSenha().equals(senha))
				return true;
		}
		return false;
	}
	
	/*---------Getters e setters----------*/
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}
	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}
	public List<Compra> getCompras() {
		return compras;
	}
	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
}
