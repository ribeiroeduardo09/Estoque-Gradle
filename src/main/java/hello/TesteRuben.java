package hello;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedList;

public class TesteRuben {
	
	public static void main(String[] args){
	
		Sistema sist = new Sistema();
		
		Produto p1 = new Produto("Teclado", 15.50f, 20.50f, 111111, "Teclado comum", 3, LocalDate.of(2017, Month.FEBRUARY, 10));
		Produto p2 = new Produto("Monitor 15 Pol.", 234.90f, 310.50f, 222222, "Monitor LG 15 Polegadas", 5, LocalDate.of(2017, Month.FEBRUARY, 28));
		
		Fornecedor f1 = new Fornecedor("Apple", 1111, "a@gmail.com", "1111-1111", "Rua Alta", LocalDate.of(2017, Month.FEBRUARY, 10), new LinkedList<Produto>(sist.getProdutos()));
		Fornecedor f2 = new Fornecedor("Google", 2222, "b@gmail.com", "2222-2222", "Rua Baixa", LocalDate.of(2017, Month.FEBRUARY, 10), new LinkedList<Produto>(sist.getProdutos()));
		
		Compra c1 = new Compra(15.50f, LocalDate.of(2017, Month.FEBRUARY, 10), new LinkedList<Produto>(sist.getProdutos()), new LinkedList<Fornecedor>(sist.getFornecedores()), 01);
		Compra c2 = new Compra(20.50f, LocalDate.of(2017, Month.FEBRUARY, 10), new LinkedList<Produto>(sist.getProdutos()), new LinkedList<Fornecedor>(sist.getFornecedores()), 02);
		
	
		sist.addProduto(p1);
		sist.addProduto(p2);
		
		assertEquals(sist.getProdutos().size(), 2);
	
		Produto produtoBuscado = sist.searchProduto(111111);
	
		assertEquals(sist.getProdutos().get(0).getNome(), "Teclado");
		
	}
}