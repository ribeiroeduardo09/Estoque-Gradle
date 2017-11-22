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
	public void addProduto(Produto prod) {
		if (isProuctAvailable(prod.getCodigoproduto())) {

			products.store(prod);
			products.commit();
			
		}
	}

	public void delProduto(int codigoproduto) {

		Query query = products.query();
		query.constrain(Produto.class);
		List<Produto> allProducts = query.execute();

		for (Produto prod : allProducts) {
			if (prod.getCodigoproduto() == codigoproduto)
				
				products.delete(prod);
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
	public void addFornecedor(Fornecedor fornecedor) {
		
		if (isProviderAvailable(fornecedor.getCnpj())) {

			providers.store(fornecedor);
			providers.store(fornecedor.getProdutos());
			providers.commit();
			
		}
	}

	public void delFornecedor(int cnpj) {

		Query query = providers.query();
		query.constrain(Fornecedor.class);
		List<Fornecedor> allProviders = query.execute();

		for (Fornecedor fornecedor : allProviders) {
			if (fornecedor.getCnpj() == cnpj) {
				
				providers.delete(fornecedor);
				providers.commit();

			}
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

	public LinkedList<Produto> searchFornecedorListP(int cnpj) {
//		List<Fornecedor> fornecedores = new LinkedList<Fornecedor>();
//		
//		Query query = providers.query();
//		query.constrain(Fornecedor.class);
//		ObjectSet<Fornecedor> allProviders = query.execute();
//		
//		for (Fornecedor tempForn:allProviders) {
//			for(Produto tempProd:tempForn.getProdutos()) {
//				if (tempProd.getCodigoproduto() == codigoproduto)
//					fornecedores.add(tempForn);
//			}
//			System.out.println(fornecedores.size());
//		}
//		
//		return fornecedores;
		
		LinkedList<Produto> lTemp = new LinkedList<Produto>();
		Fornecedor forn = null;
		
		Query query = providers.query();
		query.constrain(Fornecedor.class);
		ObjectSet<Fornecedor> allProviders = query.execute();
		
		Query query2 = products.query();
		query2.constrain(Produto.class);
		ObjectSet<Produto> allProducts = query2.execute();
		
		for (Fornecedor fornecedor : allProviders) {
			if (fornecedor.getCnpj() == cnpj) {
				forn = fornecedor;
			}
		}
		
		for (Produto produto : allProducts) {
			for (Produto produto2 : forn.getProdutos()) {
				if (produto.getCodigoproduto() == produto2.getCodigoproduto()) {
					lTemp.add(produto);
				}
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
			if (fornecedor.getCnpj() == (cnpj)) {
				
				return false;
				
			}
		}
		
		return true;
		
	}

	/*---------Compras----------*/
	public void addCompra(Compra compra) {

		if (isPurchaseAvailable(compra.getCodigocompra())) {

			purchases.store(compra);
			purchases.commit();
			
		}
	}

	public void delCompra(int codigocompra) {

		Query query = purchases.query();
		query.constrain(Compra.class);
		List<Compra> allPurchases = query.execute();

		for (Compra compra : allPurchases) {
			if (compra.getCodigocompra() == codigocompra) {
				
				purchases.delete(compra);
				purchases.commit();

			}
		}
	}

	public Compra searchCompra(int codigocompra) {

		Query query = purchases.query();
		query.constrain(Compra.class);
		List<Compra> allPurchases = query.execute();

		for (Compra compra : allPurchases) {
			if (compra.getCodigocompra() == codigocompra)
				
				return compra;
			
		}
		
		return null;
		
	}

	public boolean isPurchaseAvailable(int codigocompra) {

		Query query = purchases.query();
		query.constrain(Compra.class);
		ObjectSet<Compra> allPurchases = query.execute();

		for (Compra compra : allPurchases) {
			if (compra.getCodigocompra() == codigocompra) {
				
				return false;
				
			}
		}
		
		return true;
		
	}

	/*---------Usuários----------*/
	public void addUsuario(Usuario usuario) {

		if (isUserAvailable(usuario.getLogin())) {
			
			users.store(usuario);
			users.commit();
			
		}
	}

	public void delUsuario(String login) {
		
		Query query = users.query();
		query.constrain(Usuario.class);
		ObjectSet<Usuario> allUsers = query.execute();
		
		for (Usuario usuario : allUsers) {
			if(usuario.getLogin().equals(login)) {
				
				users.delete(usuario);
				users.commit();
				
			}
		}
	}

	public Usuario searchUsuario(String login) {
		
		Query query = users.query();
		query.constrain(Usuario.class);
		ObjectSet<Usuario> allUsers = query.execute();
		
		for (Usuario usuario : allUsers) {
			if(usuario.getLogin().equals(login)) {
				
				return usuario;
				
			}
		}
		
		return null;
		
	}

	public boolean logarUsuario(String login, String senha) {

		Query query = users.query();
		query.constrain(Usuario.class);
		ObjectSet<Usuario> allUsers = query.execute();

		for (Usuario usuario : allUsers) {
			if (usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
				
				return true;
				
			}
		}

		return false;
		
	}

	public boolean isUserAvailable(String login) {

		Query query = users.query();
		query.constrain(Usuario.class);
		ObjectSet<Usuario> allUsers = query.execute();

		for (Usuario usuario : allUsers) {
			if (usuario.getLogin() == login) {
				
				return false;
				
			}
		}
		return true;
	}

	/*---------Getters e setters----------*/
	public List<Produto> getProdutos() {
		Query query = products.query();
		query.constrain(Produto.class);
		List<Produto> todosProdutos = query.execute();
		
		return todosProdutos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public List<Fornecedor> getFornecedores() {
		Query query = providers.query();
		query.constrain(Fornecedor.class);
		List<Fornecedor> todosFornecedores = query.execute();
		
		return todosFornecedores;
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	public List<Compra> getCompras() {
		Query query = purchases.query();
		query.constrain(Compra.class);
		List<Compra> todasCompras = query.execute();
		
		return todasCompras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

	public List<Usuario> getUsuarios() {
		Query query = users.query();
		query.constrain(Usuario.class);
		List<Usuario> todosUsuarios = query.execute();
		
		return todosUsuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
}
