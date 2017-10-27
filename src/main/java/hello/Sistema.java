package hello;

import java.util.LinkedList;
import java.util.List;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

public class Sistema {

	/*---------Import do Banco de Dados----------*/
	ObjectContainer products = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/products.db4o");
	ObjectContainer providers = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/providers.db4o");
	ObjectContainer users = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/users.db4o");
	ObjectContainer purchases = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/purchases.db4o");
	ObjectContainer adms = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/adms.db4o");

	/*---------Declaração----------*/
	private List<Produto> produtos = new LinkedList<Produto>();
	private List<Fornecedor> fornecedores = new LinkedList<Fornecedor>();
	private List<Compra> compras = new LinkedList<Compra>();
	private List<Usuario> usuarios = new LinkedList<Usuario>();

	/*---------Produtos----------*/
	public boolean addProduto(Produto prod) {

		if (isProuctAvailable(prod.getCodigoproduto())) {

			products.store(prod);
			products.commit();

			return true;
		}
		return false;
	}

	public void delProduto(int codigoproduto) {
		
		Query query = products.query();
		query.constrain(Produto.class);
		List<Produto> allProducts = query.execute();

		for (Produto prod : allProducts) {
			if (prod.getCodigoproduto() == codigoproduto)
				products.delete(codigoproduto);
				products.commit();
		}
	}

	public Produto searchProduto(int codigoproduto) {

		Query query = products.query();
		query.constrain(Produto.class);
		ObjectSet<Produto> allProducts = query.execute();

		for (Produto produto : allProducts) {
			if (produto.getCodigoproduto() == codigoproduto) {
				return produto;
			}
		}
		return null;
	}

	public boolean isProuctAvailable(int codigoproduto) {
		
		Query query = products.query();
		query.constrain(Produto.class);
		ObjectSet<Produto> allProducts = query.execute();

		for (Produto produto : allProducts) {
			if (produto.getCodigoproduto() == (codigoproduto))
				return false;
		}
		return true;
	}

	/*---------Fornecedores----------*/
	public boolean addFornecedor(Fornecedor fornecedor) {
		
		if (isProviderAvailable(fornecedor.getCnpj())) {

			providers.store(fornecedor);
			providers.commit();

			return true;
		}
		return false;
	}

	public void delFornecedor(int cnpj) {

		Query query = providers.query();
		query.constrain(Fornecedor.class);
		List<Fornecedor> allProviders = query.execute();

		for (Fornecedor fornecedor : allProviders) {
			if (fornecedor.getCnpj() == cnpj)
				providers.delete(cnpj);
				providers.commit();
		}
	}

	public Fornecedor searchFornecedor(int cnpj) {
		
		Query query = providers.query();
		query.constrain(Fornecedor.class);
		ObjectSet<Fornecedor> allProviders = query.execute();

		for (Fornecedor fornecedor : allProviders) {
			if (fornecedor.getCnpj() == cnpj) {
				return fornecedor;
			}
		}
		return null;
	}

	public LinkedList<Produto> searchFornecedorListP(int cnpj) { //TODO Passar este método para o Banco de Dados.
		LinkedList<Produto> lTemp = new LinkedList<Produto>();
		Fornecedor forn = null;
		for (Fornecedor tempForn : fornecedores) {
			if (tempForn.getCnpj() == cnpj)
				forn = tempForn;
		}
		for (Produto tempProd : produtos) {
			for (Produto tempProd2 : forn.getProdutos()) {
				if (tempProd.getCodigoproduto() == tempProd2.getCodigoproduto())
					lTemp.add(tempProd);
			}
		}
		return lTemp;
	}
	
	

	public List<Fornecedor> searchFornecedorNome(String nomeFornecedor) {
		
		List<Fornecedor> fornList = new LinkedList<Fornecedor>();
		
		Query query = providers.query();
		query.constrain(Fornecedor.class);
		ObjectSet<Fornecedor> allProviders = query.execute();
		
		for (Fornecedor fornecedor : allProviders) {
			if (fornecedor.getNome().toLowerCase().contains(nomeFornecedor.toLowerCase())) {
				fornList.add(fornecedor);
			}
		}
		
		return fornList;
	}

	public boolean isProviderAvailable(int cnpj) {
		
		Query query = providers.query();
		query.constrain(Fornecedor.class);
		ObjectSet<Fornecedor> allProviders = query.execute();

		for (Fornecedor fornecedor : allProviders) {
			if (fornecedor.getCnpj() == (cnpj))
				return false;
		}
		return true;
	}

	/*---------Compras----------*/
	public void addCompra(Compra compra) {
		compras.add(compra);
	}

	public void delCompra(int codigocompra) {
		for (Compra comp : compras) {
			if (comp.getCodigocompra() == codigocompra)
				compras.remove(comp);
		}
	}

	public Compra searchCompra(int codigocompra) {
		for (Compra comp : compras) {
			if (comp.getCodigocompra() == codigocompra)
				return comp;
		}
		return null;
	}

	/*---------Usuários----------*/
	public void addUsuario(Usuario usuario) {
		usuarios.add(usuario);
	}

	public void delUsuario(String login) {
		for (Usuario usr : usuarios) {
			if (usr.getLogin().equals(login))
				usuarios.remove(usr);
		}
	}

	public Usuario searchUsuario(String login) {
		for (Usuario usr : usuarios) {
			if (usr.getLogin().equals(login))
				return usr;
		}
		return null;
	}

	public boolean logarUsuario(String login, String senha) {
		for (Usuario usr : usuarios) {
			if (usr.getLogin().equals(login) && usr.getSenha().equals(senha))
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
