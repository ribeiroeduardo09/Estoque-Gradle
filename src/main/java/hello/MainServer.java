package hello;

import static spark.Spark.*;

import java.time.LocalDate;
import java.time.Month;


public class MainServer {
	
	final static Sistema sistema = new Sistema();
	
    public static void main(String[] args) {

		// Get port config of heroku on environment variable
        ProcessBuilder process = new ProcessBuilder();
        Integer port;
        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 8000;
        }
        port(port);

		//Servir conteudo html, css e javascript
		staticFileLocation("/static");

		inicializarProdutos();
		inicializarUsuarios();
		inicializarClientes();
		inicializarFornecedores();
		inicializarCompras();
		inicializarVendas();
		
		Controller controller = new Controller(sistema);
		
		controller.buscarProduto();
		controller.buscarUsuario();
		controller.buscarCliente();
		controller.buscarFornecedor();
		controller.buscarCompra();
		controller.buscarVenda();
    }
    
    public static void inicializarProdutos(){
    	sistema.addProduto(new Produto("Monitor", 8.00f, 12.50f, 01, "Monitor LCD", 3, LocalDate.of(2017, Month.FEBRUARY, 10)));
    }
    
    public static void inicializarUsuarios(){
    	sistema.addUsuario(new Usuario("ruben", "rbn", "123", 01, "estudante", LocalDate.of(2017, Month.AUGUST, 18)));
    	sistema.addUsuario(new Usuario("eduardo", "ed", "789", 02, "estudante", LocalDate.of(2017, Month.AUGUST, 18)));
    }
    public static void inicializarClientes(){
    	sistema.addCliente(new Cliente(01, "ruben", "111-11", "Rua Alta", "1111-1111", LocalDate.of(2017, Month.AUGUST, 18)));
    }
    public static void inicializarFornecedores(){
    	
    }
    public static void inicializarCompras(){
    	
    }
    public static void inicializarVendas(){
    	
    }
}
