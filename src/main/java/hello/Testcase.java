package hello;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Test;

public class Testcase {

	@Test
	public void test() {
		Produto p1 = new Produto("Teclado", 15.50f, 20.50f, 111111, "Teclado comum", 3, LocalDate.of(2017, Month.FEBRUARY, 10));
		Produto p2 = new Produto("Monitor 15 Pol.", 234.90f, 310.50f, 222222, "Monitor LG 15 Polegadas", 5, LocalDate.of(2017, Month.FEBRUARY, 28));
			
		Sistema sist = new Sistema();
	
		sist.addProduto(p1);
		sist.addProduto(p2);
		
		assertEquals(sist.getProdutos().size(), 2);
	
		Produto produtoBuscado = sist.searchProduto(111111);
	
		assertEquals(sist.getProdutos().get(0).getNome(), "Teclado");
		
		Usuario u1 = new Usuario("Eduardo", "ribeiroeduardo09", "senha123", 13729, "Desenvolvedor", LocalDate.of(2017, Month.SEPTEMBER, 01));
		Usuario u2 = new Usuario("Ruben", "rubenfilipeao", "senha321", 14582, "Desenvolvedor", LocalDate.of(2017, Month.SEPTEMBER, 01));
		
		
	}

}
