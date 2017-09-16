package hello;

import static spark.Spark.get;

import java.util.LinkedList;

import com.google.gson.Gson;

public class Controller {
	
	private Sistema sistema;
	
	public Controller(Sistema sistema)
	{
		this.sistema = sistema;
	}
	
	//			PRODUTO
	public void buscarProduto()
	{
		get("/estoqueProduto/:codigoproduto", (req, res) ->
		{
			Produto produtoEncontrado = sistema.searchProduto(Integer.parseInt(req.params(":codigoproduto")));
			return new Gson().toJson(produtoEncontrado);
		});
	}
	public void buscarProdutoFornecedor()
	{
		get("/estoqueProdutoF/:fornecedor", (req, res) ->
		{	
			LinkedList<Produto> lProd = sistema.searchProdutoList(req.params(":fornecedor"));
			return new Gson().toJson(lProd);
		});
	}
	

	//			FORNECEDOR
	public void buscarFornecedor()
	{
		get("/estoqueFornecedor/:cnpj", (req, res) ->
		{
			Fornecedor fornecedorEncontrado = sistema.searchFornecedor(Integer.parseInt(req.params(":cnpj")));
			return new Gson().toJson(fornecedorEncontrado);
		});
	}
	//			COMPRA
	public void buscarCompra()
	{
		get("/estoqueCompra/:codigocompra", (req, res) ->
		{
			Compra compraEncontrada = sistema.searchCompra(Integer.parseInt(req.params(":codigocompra")));
			return new Gson().toJson(compraEncontrada);
		});
	}
	//			USUARIO
	public void buscarUsuario()
	{
		get("/estoqueUsuario/:login", (req, res) ->
		{
			Usuario usuarioEncontrado = sistema.searchUsuario(req.params(":login"));
			return new Gson().toJson(usuarioEncontrado);
		});
	}
}
