package hello;

import static spark.Spark.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedList;


public class MainServer {
	
	final static Sistema sistema = new Sistema();
	
    public static void main(String[] args) {

		// Get port config of heroku on environment variable
        ProcessBuilder process = new ProcessBuilder();
        Integer port;
        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 12345;
        }
        port(port);

		//Servir conteudo html, css e javascript
		staticFileLocation("/static");

		inicializarProdutos();
		inicializarFornecedores();
		inicializarCompras();
		inicializarUsuarios();

		
		Controller controller = new Controller(sistema);
		
		controller.addProduto();
		controller.delProduto();
		controller.buscarProduto();
		controller.addFornecedor();
		controller.delFornecedor();
		controller.buscarFornecedor();
		controller.buscarFornecedorProduto();
		controller.buscarFornecedorNome();
		controller.addCompra();
		controller.delCompra();
		controller.buscarCompra();
		controller.addUsuario();
		controller.delUsuario();
		controller.buscarUsuario();
		controller.logarUsuario();
    }
    
    public static void inicializarProdutos() {};
    public static void inicializarFornecedores(){
    	LinkedList<Produto> lista = new LinkedList<Produto>();
    	lista.add(sistema.searchProduto(01));
    	lista.add(sistema.searchProduto(02));
    	System.out.println(lista.get(0).getCodigoproduto());
    	System.out.println(lista.get(1).getCodigoproduto());
    	sistema.addFornecedor(new Fornecedor("Apple", 4444, "a@gmail.com", "1111-1111", "Rua Alta", LocalDate.of(2017, Month.AUGUST, 18), lista));
    }
    public static void inicializarCompras() {};
    public static void inicializarUsuarios() {};
    
}
