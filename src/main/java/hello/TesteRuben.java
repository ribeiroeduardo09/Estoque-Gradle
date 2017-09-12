package hello;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedList;

import org.junit.Test;

public class TesteRuben {
	
	@Test
	public void teste(){
	
		Sistema sist = new Sistema();
		
		Produto p1 = new Produto("Notebook", 8.00f, 12.50f, 01, "Windows 10", 3, LocalDate.of(2017, Month.FEBRUARY, 10));
		Produto p2 = new Produto("Monitor", 234.90f, 310.50f, 02, "15 Polegadas", 5, LocalDate.of(2017, Month.FEBRUARY, 28));
		Produto p3 = new Produto("Notebook", 48.00f, 56.50f, 03, "Híbrido", 22, LocalDate.of(2017, Month.JANUARY, 30));
		
		Fornecedor f1 = new Fornecedor("Apple", 1111, "a@gmail.com", "1111-1111", "Rua Alta", LocalDate.of(2017, Month.FEBRUARY, 10), new LinkedList<Produto>(sist.getProdutos()));
		Fornecedor f2 = new Fornecedor("Google", 2222, "b@gmail.com", "2222-2222", "Rua Baixa", LocalDate.of(2017, Month.FEBRUARY, 10), new LinkedList<Produto>(sist.getProdutos()));
		
		Compra c1 = new Compra(15.50f, LocalDate.of(2017, Month.FEBRUARY, 10), new LinkedList<Produto>(sist.getProdutos()), new LinkedList<Fornecedor>(sist.getFornecedores()), 01);
		Compra c2 = new Compra(20.50f, LocalDate.of(2017, Month.FEBRUARY, 10), new LinkedList<Produto>(sist.getProdutos()), new LinkedList<Fornecedor>(sist.getFornecedores()), 02);
		
		//			PRODUTO
		// Atribuição de Produtos
		sist.addProduto(p1);
		sist.addProduto(p2);
		sist.addProduto(p3);
		
		Produto produtoBuscado = sist.searchProduto(02);
		
		LinkedList<Produto> lProd = new LinkedList<Produto>();
		lProd = sist.searchProdutoList("Notebook");
		
		// addProduto
		assertEquals(sist.getProdutos().size(), 3);
		// searchProduto
		assertEquals(produtoBuscado.getNome(), "Monitor");
		// searchProdutoList
		assertEquals(lProd.size(), 2);
		// encontrar pela posição
		assertEquals(sist.getProdutos().get(2).getNome(), "Notebook");
	}
}