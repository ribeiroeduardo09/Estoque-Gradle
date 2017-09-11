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
            port = 8000;
        }
        port(port);

		//Servir conteudo html, css e javascript
		staticFileLocation("/static");

		inicializarProdutos();
		inicializarUsuarios();
		inicializarFornecedores();
		inicializarCompras();

		
		Controller controller = new Controller(sistema);
		
		controller.buscarProduto();
		controller.buscarUsuario();
		controller.buscarFornecedor();
		controller.buscarCompra();
		
    }
    
    public static void inicializarProdutos(){
    	sistema.addProduto(new Produto("Apple", 8.00f, 12.50f, 01, "Monitor LCD", 3, LocalDate.of(2017, Month.FEBRUARY, 10)));
    	sistema.addProduto(new Produto("Cadeira", 10.00f, 18.00f, 02, "Cadeira de couro", 7, LocalDate.of(2017, Month.FEBRUARY, 10)));
    	sistema.addProduto(new Produto("Apple", 48.00f, 56.50f, 03, "Bebedouro prata", 22, LocalDate.of(2017, Month.JANUARY, 30)));
    }
    public static void inicializarUsuarios(){
    	sistema.addUsuario(new Usuario("ruben", "rbn", "123", 01, "estudante", LocalDate.of(2017, Month.AUGUST, 18)));
    	sistema.addUsuario(new Usuario("eduardo", "ed", "789", 02, "estudante", LocalDate.of(2017, Month.AUGUST, 18)));
    }
    public static void inicializarFornecedores(){
    	sistema.addFornecedor(new Fornecedor("Apple", 01, "a@gmail.com", "1111-1111", "Rua Alta", LocalDate.of(2017, Month.AUGUST, 18), new LinkedList<Produto>(sistema.getProdutos())));
    }
    public static void inicializarCompras(){    	 	
    	sistema.addCompra(new Compra(23.00f, LocalDate.of(2017, Month.AUGUST, 18), new LinkedList<Produto>(sistema.getProdutos()), new LinkedList<Fornecedor>(sistema.getFornecedores()), 01));
    }
}
