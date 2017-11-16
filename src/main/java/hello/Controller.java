package hello;

import static spark.Spark.get;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;

public class Controller {
	
	private Sistema sistema;
	
	public Controller(Sistema sistema)
	{
		this.sistema = sistema;
	}
	
	/*---------Produtos----------*/
	public void addProduto()
	{
		get("/estoqueProdAdd/:nome/:valorcompra/:codigoproduto/:descricao/:quantidade/:datacad", (req, res) ->
		{
			String dataString = req.params(":datacad");
	    	String[] dataSeparada = dataString.split(" ");
	    	LocalDate data = LocalDate.of(Integer.parseInt(dataSeparada[2]), Integer.parseInt(dataSeparada[1]), Integer.parseInt(dataSeparada[0]));
			Produto prod = new Produto(req.params(":nome"), Float.parseFloat(req.params(":valorcompra")), Integer.parseInt(req.params(":codigoproduto")), req.params(":descricao"), Integer.parseInt(req.params(":quantidade")), data);
			sistema.addProduto(prod);
			return "Produto " + req.params(":codigoproduto") + " adicionado com sucesso!";
		});
	}
	public void delProduto()
	{
		get("/estoqueProdDel/:codigoproduto", (req, res) ->
		{
			sistema.delProduto(Integer.parseInt(req.params(":codigoproduto")));
			return "Produto " + req.params(":codigoproduto") + " deletado com sucesso!";
		});
	}
	public void buscarProduto()
	{
		get("/estoqueProdBuscar/:codigoproduto", (req, res) ->
		{
			Produto produtoEncontrado = sistema.searchProduto(Integer.parseInt(req.params(":codigoproduto")));
			return new Gson().toJson(produtoEncontrado);
		});
	}
	
	/*---------Fornecedores----------*/
	//Add
	public void addFornecedor()
	{
		get("/estoqueFornAdd/:nomeFornecedor/:cnpj/:email/:telefone/:endereco/:datacadastroforn/:produtos", (req, res) ->
		{
			String dataString = req.params(":datacadastroforn");
	    	String[] dataSeparada = dataString.split(" ");
	    	LocalDate data = LocalDate.of(Integer.parseInt(dataSeparada[2]), Integer.parseInt(dataSeparada[1]), Integer.parseInt(dataSeparada[0]));
	    	
	    	String produtosString = req.params(":produtos");
	    	String[] produtosSeparado = produtosString.split(" ");
	    	
	    	LinkedList<Produto> todosProdutos = new LinkedList<Produto>(sistema.getProdutos());
	    	LinkedList<Produto> produtos = new LinkedList<Produto>();
	    	
	    	for(int i = 0; i < produtosSeparado.length; i++){
	    		for(Produto temp:todosProdutos){
		    		if(temp.getCodigoproduto() == Integer.parseInt(produtosSeparado[i]))
						produtos.add(temp);		
		    	}
	    	}
	    	
	    	if(produtos.size() > 0){
	    		Fornecedor forn = new Fornecedor(req.params(":nomeFornecedor"), Integer.parseInt(req.params(":cnpj")), 
	    				req.params(":email"), req.params(":telefone"), req.params(":endereco"), data, produtos);
	    		
	    		sistema.addFornecedor(forn);
	    		
	    		return "Fornecedor " + req.params(":CNPJ") + " adicionado com sucesso!";
	    		
	    	} else {
	    		
	    		return "Fornecedor deve ter ao menos um produto para ser cadastrado.";
	    		
	    	}
		});
	}
	
	//Del
	public void delFornecedor()
	{
		get("/estoqueFornDel/:cnpj", (req, res) ->
		{
			sistema.delFornecedor(Integer.parseInt(req.params(":cnpj")));
			return "";
		});
	}
	
	//Search
	public void buscarFornecedorTodos()
	{
		get("/estoqueFornBuscarTodos/", (req, res) ->
		{
			List<Fornecedor> todosFornecedores = sistema.getFornecedores();
			return new Gson().toJson(todosFornecedores);
		});
	}
	public void buscarFornecedor()
	{
		get("/estoqueFornBuscar/:cnpj", (req, res) ->
		{
			Fornecedor fornecedorEncontrado = sistema.searchFornecedor(Integer.parseInt(req.params(":cnpj")));
			return new Gson().toJson(fornecedorEncontrado);
		});
	}
	public void buscarFornecedorProduto()
	{
		get("/estoqueFornBuscarP/:codigoproduto", (req, res) ->
		{	
			List<Fornecedor> fornecedoresEncontrados = sistema.searchFornecedorListP(Integer.parseInt(req.params(":codigoproduto")));
			return new Gson().toJson(fornecedoresEncontrados);
		});
	}
	public void buscarFornecedorNome()
	{
		get("/estoqueFornBuscarN/:nomeForn", (req, res) ->
		{
			List<Fornecedor> fornecedorEncontrados = sistema.searchFornecedorNome(req.params(":nomeForn"));
			return new Gson().toJson(fornecedorEncontrados);
		});
	}
	
	/*---------Compras----------*/
	public void addCompra()
	{
		get("/estoqueCompAdd/:valortotal/:datacompra/:produtos/:fornecedores/:codigocompra", (req, res) ->
		{
			String dataString = req.params(":datacompra");
	    	String[] dataSeparada = dataString.split(" ");
	    	LocalDate data = LocalDate.of(Integer.parseInt(dataSeparada[2]), Integer.parseInt(dataSeparada[1]), Integer.parseInt(dataSeparada[0]));
	    	
	    	String produtosString = req.params(":produtos");
	    	String[] produtosSeparado = produtosString.split(" ");
	    	LinkedList<Produto> todosProdutos = new LinkedList<Produto>(sistema.getProdutos());
	    	LinkedList<Produto> produtos = new LinkedList<Produto>();
	    	for(int i = 0; i < produtosSeparado.length; i++){
	    		for(Produto temp:todosProdutos){
		    		if(temp.getCodigoproduto() == Integer.parseInt(produtosSeparado[i]))
						produtos.add(temp);
		    	}
	    	}
	    	String fornecedoresString = req.params(":fornecedores");
	    	String[] fornecedoresSeparado = fornecedoresString.split(" ");
	    	LinkedList<Fornecedor> todosFornecedores = new LinkedList<Fornecedor>(sistema.getFornecedores());
	    	LinkedList<Fornecedor> fornecedores = new LinkedList<Fornecedor>();
	    	for(int i = 0; i < fornecedoresSeparado.length; i++){
	    		for(Fornecedor temp:todosFornecedores){
		    		if(temp.getCnpj() == Integer.parseInt(fornecedoresSeparado[i]))
		    			fornecedores.add(temp);
		    	}
	    	}
	    	
	    	if(produtos.size() > 0){
	    		Compra comp = new Compra(Float.parseFloat(req.params(":valortotal")), data, produtos, fornecedores, Integer.parseInt(req.params(":codigocompra")));
	    		sistema.addCompra(comp);
	    	}			
			return "Compra " + req.params(":codigocompra") + " adicionada com sucesso!";
		});
	}
	public void delCompra()
	{
		get("/estoqueCompDel/:codigocompra", (req, res) ->
		{
			sistema.delCompra(Integer.parseInt(req.params(":codigocompra")));
			return "Compra " + req.params(":codigocompra") + " deletada com sucesso!";
		});
	}
	public void buscarCompra()
	{
		get("/estoqueCompBuscar/:codigocompra", (req, res) ->
		{
			Compra compraEncontrada = sistema.searchCompra(Integer.parseInt(req.params(":codigocompra")));
			return new Gson().toJson(compraEncontrada);
		});
	}
	
	/*---------Usuários----------*/
	public void addUsuario()
	{
		get("/estoqueUsuaAdd/:nomeusuario/:login/:senha/:matricula/:cargo/:datacadastro", (req, res) ->
		{
			String dataString = req.params(":datacadastro");
	    	String[] dataSeparada = dataString.split(" ");
	    	LocalDate data = LocalDate.of(Integer.parseInt(dataSeparada[2]), Integer.parseInt(dataSeparada[1]), Integer.parseInt(dataSeparada[0]));
	    	Usuario usua = new Usuario(req.params(":nomeusuario"), req.params(":login"), req.params(":senha"), Integer.parseInt(req.params(":matricula")), req.params(":cargo"), data);
			sistema.addUsuario(usua);
			return "Usuário " + req.params(":login") + " adicionado com sucesso!";
		});
	}
	public void delUsuario()
	{
		get("/estoqueUsuaDel/:login", (req, res) ->
		{
			sistema.delUsuario(req.params(":login"));
			return "Usuário " + req.params(":login") + " deletado com sucesso!";
		});
	}
	public void buscarUsuario()
	{
		get("/estoqueUsuaBuscar/:login", (req, res) ->
		{
			Usuario usuarioEncontrado = sistema.searchUsuario(req.params(":login"));
			return new Gson().toJson(usuarioEncontrado);
		});
	}
	public void logarUsuario()
	{
		get("/estoqueUsuaLogar/:login/:senha", (req, res) ->
		{
			boolean verificacao = sistema.logarUsuario(req.params(":login"), req.params(":senha"));
			if(verificacao == true)
				return "Logado com sucesso! A verificação resultou " + verificacao;
			else
				return "Nome de usuário ou senha incorreto(s). A verificação resultou " + verificacao;
		});
	}
}
