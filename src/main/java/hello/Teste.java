package hello;

import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedList;

public class Teste {
	
	public static void main(String args[]) { 
		
		Sistema sistema = new Sistema();
		
		sistema.addFornecedor(new Fornecedor("Apple", 1111, "a@gmail.com", "1111-1111", "Rua Alta", LocalDate.of(2017, Month.FEBRUARY, 10), new LinkedList<Produto>(sistema.getProdutos())));
    	sistema.addFornecedor(new Fornecedor("Google", 2222, "b@gmail.com", "2222-2222", "Rua Baixa", LocalDate.of(2017, Month.FEBRUARY, 10), new LinkedList<Produto>(sistema.getProdutos())));
    	sistema.addFornecedor(new Fornecedor("HP", 3333, "c@gmail.com", "3333-3333", "Rua Média", LocalDate.of(2017, Month.FEBRUARY, 10), new LinkedList<Produto>(sistema.getProdutos())));
    	sistema.addFornecedor(new Fornecedor("Vila Velha LTDA", 4444, "d@gmail.com", "4444-4444", "Rua Média", LocalDate.of(2017, Month.FEBRUARY, 10), new LinkedList<Produto>(sistema.getProdutos())));
    	sistema.addFornecedor(new Fornecedor("Vila Nova LTDA", 5555, "e@gmail.com", "5555-5555", "Rua Média", LocalDate.of(2017, Month.FEBRUARY, 10), new LinkedList<Produto>(sistema.getProdutos())));
		
		System.out.println(sistema.searchFornecedorNome("Vila"));
		
	}
}