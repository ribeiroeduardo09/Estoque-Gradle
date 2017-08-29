package hello;

import static spark.Spark.get;

import java.util.List;

import com.google.gson.Gson;

public class Controller {
	
	private Sistema sistema;
	
	public Controller(Sistema sistema)
	{
		this.sistema = sistema;
	}
	
	public void buscarProduto()
	{
		get("/estoqueProduto/:codigoproduto", (req, res) ->
		{
			Produto produtoEncontrado = sistema.searchProduto(Integer.parseInt(req.params(":codigoproduto")));
			return new Gson().toJson(produtoEncontrado);
		});
	}
	
	public void buscarUsuario()
	{
		get("/estoqueUsuario/:login", (req, res) ->
		{
			Usuario usuarioEncontrado = sistema.searchUsuario(req.params(":login"));
			return new Gson().toJson(usuarioEncontrado);
		});
	}
	
	public void buscarCliente()
	{
		get("/estoqueCliente/:codigocliente", (req, res) ->
		{
			Cliente clienteEncontrado = sistema.searchCliente(Integer.parseInt(req.params(":codigocliente")));
			return new Gson().toJson(clienteEncontrado);
		});
	}
	
	public void buscarFornecedor()
	{
		get("/estoqueFornecedor/:cnpj", (req, res) ->
		{
			Fornecedor fornecedorEncontrado = sistema.searchFornecedor(Integer.parseInt(req.params(":cnpj")));
			return new Gson().toJson(fornecedorEncontrado);
		});
	}
	
	public void buscarCompra()
	{
		get("/estoqueCompra/:codigocompra", (req, res) ->
		{
			Compra compraEncontrada = sistema.searchCompra(Integer.parseInt(req.params(":codigocompra")));
			return new Gson().toJson(compraEncontrada);
		});
	}
	
	public void buscarVenda()
	{
		get("/estoqueVenda/:codigo", (req, res) ->
		{
			Venda vendaEncontrada = sistema.searchVenda(Integer.parseInt(req.params(":codigo")));
			return new Gson().toJson(vendaEncontrada);
		});
	}	
}
