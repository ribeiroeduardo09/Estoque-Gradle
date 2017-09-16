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
            port = 1234;
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
		controller.buscarFornecedor();
		controller.buscarCompra();
		controller.buscarUsuario();
		
    }
    
    public static void inicializarProdutos(){
    	sistema.addProduto(new Produto("Notebook", "HP", 8.00f, 12.50f, 01, "Windows 10", 3, LocalDate.of(2017, Month.FEBRUARY, 10)));
    	sistema.addProduto(new Produto("Monitor", "Dell", 234.90f, 310.50f, 02, "15 Polegadas", 5, LocalDate.of(2017, Month.FEBRUARY, 28)));
    	sistema.addProduto(new Produto("Notebook", "Dell", 48.00f, 56.50f, 03, "Híbrido", 22, LocalDate.of(2017, Month.JANUARY, 30)));
    	sistema.addProduto(new Produto("Smartphone", "Apple", 43.00f, 59.50f, 04, "SmartP", 20, LocalDate.of(2017, Month.JANUARY, 30)));
    }
    public static void inicializarFornecedores(){
    	sistema.addFornecedor(new Fornecedor("Apple", 1111, "a@gmail.com", "1111-1111", "Rua Alta", LocalDate.of(2017, Month.FEBRUARY, 10), new LinkedList<Produto>(sistema.getProdutos())));
    	sistema.addFornecedor(new Fornecedor("Google", 2222, "b@gmail.com", "2222-2222", "Rua Baixa", LocalDate.of(2017, Month.FEBRUARY, 10), new LinkedList<Produto>(sistema.getProdutos())));
    	sistema.addFornecedor(new Fornecedor("HP", 3333, "c@gmail.com", "3333-3333", "Rua Média", LocalDate.of(2017, Month.FEBRUARY, 10), new LinkedList<Produto>(sistema.getProdutos())));
    }
    public static void inicializarCompras(){    	 	
    	sistema.addCompra(new Compra(15.50f, LocalDate.of(2017, Month.FEBRUARY, 10), new LinkedList<Produto>(sistema.getProdutos()), new LinkedList<Fornecedor>(sistema.getFornecedores()), 01));
    	sistema.addCompra(new Compra(20.50f, LocalDate.of(2017, Month.FEBRUARY, 10), new LinkedList<Produto>(sistema.getProdutos()), new LinkedList<Fornecedor>(sistema.getFornecedores()), 02));
    	sistema.addCompra(new Compra(40.50f, LocalDate.of(2017, Month.FEBRUARY, 10), new LinkedList<Produto>(sistema.getProdutos()), new LinkedList<Fornecedor>(sistema.getFornecedores()), 03));
    }
    public static void inicializarUsuarios(){
    	sistema.addUsuario(new Usuario("Primeiro Usuário", "aa", "123", 01, "Diretor", LocalDate.of(2017, Month.FEBRUARY, 10)));
    	sistema.addUsuario(new Usuario("Segundo Usuário", "bb", "456", 02, "Empilhadeirista", LocalDate.of(2017, Month.FEBRUARY, 10)));
    	sistema.addUsuario(new Usuario("Terceiro Usuário", "cc", "789", 03, "Empilhadeirista", LocalDate.of(2017, Month.FEBRUARY, 10)));
    }
}
