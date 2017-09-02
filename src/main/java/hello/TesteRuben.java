package hello;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.Month;

public class TesteRuben {
	
	public static void main(String[] args){
	
		Produto p1 = new Produto("Teclado", 15.50f, 20.50f, 111111, "Teclado comum", 3, LocalDate.of(2017, Month.FEBRUARY, 10));
		Produto p2 = new Produto("Monitor 15 Pol.", 234.90f, 310.50f, 222222, "Monitor LG 15 Polegadas", 5, LocalDate.of(2017, Month.FEBRUARY, 28));
		
//		Venda venda1 = new Venda(15.30f, "Debito", LocalDate.of(2017, Month.APRIL, 13), 1472, p1.getNome());
//		
//		venda1.addProduto(p1);
//		venda1.addProduto(p2);
//	
//		assertEquals(venda1.getProdutos().size(), 2);
//	
//		Produto produtoBuscado = venda1.getProdutos(111111);
//	
//		assertEquals(venda1.getProdutos().get(0).getNome(), "Teclado");
//	
		Sistema sist = new Sistema();
	
		sist.addProduto(p1);
		sist.addProduto(p2);
		
		assertEquals(sist.getProdutos().size(), 2);
	
		Produto produtoBuscado = sist.searchProduto(111111);
	
		assertEquals(sist.getProdutos().get(0).getNome(), "Teclado");
		
	}
}