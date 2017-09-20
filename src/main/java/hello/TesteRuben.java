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
		
		Produto p1 = new Produto("Notebook", 8.00f, 01, "Windows 10", 3, LocalDate.of(2017, Month.FEBRUARY, 10));
		Produto p2 = new Produto("Monitor", 234.90f, 02, "15 Polegadas", 5, LocalDate.of(2017, Month.FEBRUARY, 28));
		Produto p3 = new Produto("Notebook", 48.00f, 03, "Híbrido", 22, LocalDate.of(2017, Month.JANUARY, 30));
		Produto p4 = new Produto("Smartphone", 43.00f, 04, "SmartP", 20, LocalDate.of(2017, Month.JANUARY, 30));
		
		Fornecedor f1 = new Fornecedor("Apple", 1111, "a@gmail.com", "1111-1111", "Rua Alta", LocalDate.of(2017, Month.FEBRUARY, 10), new LinkedList<Produto>(sist.getProdutos()));
		Fornecedor f2 = new Fornecedor("Dell", 2222, "b@gmail.com", "2222-2222", "Rua Baixa", LocalDate.of(2017, Month.FEBRUARY, 10), new LinkedList<Produto>(sist.getProdutos()));
		Fornecedor f3 = new Fornecedor("HP", 3333, "c@gmail.com", "3333-3333", "Rua Média", LocalDate.of(2017, Month.FEBRUARY, 10), new LinkedList<Produto>(sist.getProdutos()));
		
		Compra c1 = new Compra(15.50f, LocalDate.of(2017, Month.FEBRUARY, 10), new LinkedList<Produto>(sist.getProdutos()), new LinkedList<Fornecedor>(sist.getFornecedores()), 01);
		Compra c2 = new Compra(20.50f, LocalDate.of(2017, Month.FEBRUARY, 10), new LinkedList<Produto>(sist.getProdutos()), new LinkedList<Fornecedor>(sist.getFornecedores()), 02);
		Compra c3 = new Compra(40.50f, LocalDate.of(2017, Month.FEBRUARY, 10), new LinkedList<Produto>(sist.getProdutos()), new LinkedList<Fornecedor>(sist.getFornecedores()), 03);
		
		Usuario u1 = new Usuario("Primeiro Usuário", "aa", "123", 01, "Diretor", LocalDate.of(2017, Month.FEBRUARY, 10));
		Usuario u2 = new Usuario("Segundo Usuário", "bb", "456", 02, "Empilhadeirista", LocalDate.of(2017, Month.FEBRUARY, 10));
		Usuario u3 = new Usuario("Terceiro Usuário", "cc", "789", 03, "Empilhadeirista", LocalDate.of(2017, Month.FEBRUARY, 10));
		
		//			PRODUTO
		// Atribuição de Produtos
		sist.addProduto(p1);
		sist.addProduto(p2);
		sist.addProduto(p3);
		sist.addProduto(p4);
		
		Produto produtoBuscado = sist.searchProduto(02);
		
		// addProduto
		assertEquals(sist.getProdutos().size(), 4);
		// searchProduto
		assertEquals(produtoBuscado.getNome(), "Monitor");
		// search pela posição
		assertEquals(sist.getProdutos().get(2).getNome(), "Notebook");
		// deletar
		sist.delProduto(03);
		assertEquals(sist.getProdutos().size(), 3);
		
		//			FORNECEDOR
		// Atribuição de Fornecedores
		sist.addFornecedor(f1);
		sist.addFornecedor(f2);
		sist.addFornecedor(f3);
		
		Fornecedor fornecedorBuscado = sist.searchFornecedor(2222);
		
		// addFornecedor
		assertEquals(sist.getFornecedores().size(), 3);
		// searchFornecedor
		assertEquals(fornecedorBuscado.getNome(), "Dell");
		// search pela posição
		assertEquals(sist.getFornecedores().get(2).getCnpj(), 3333);
		// deletar
		sist.delFornecedor(3333);
		assertEquals(sist.getFornecedores().size(), 2);
		
		//			COMPRA
		// Atribuição de Compras
		sist.addCompra(c1);
		sist.addCompra(c2);
		sist.addCompra(c3);
		
		Compra compraBuscada = sist.searchCompra(02);
		
		// addCompra
		assertEquals(sist.getCompras().size(), 3);
		// searchCompra
		assertEquals(compraBuscada.getCodigocompra(), 02);
		// search pela posição
		assertEquals(sist.getCompras().get(2).getCodigocompra(), 03);
		// deletar
		sist.delCompra(03);
		assertEquals(sist.getCompras().size(), 2);
		
		//			USUARIO
		// Atribuição de Usuarios
		sist.addUsuario(u1);
		sist.addUsuario(u2);
		sist.addUsuario(u3);
		
		Usuario usuarioBuscado = sist.searchUsuario("bb");
		
		// addUsuario
		assertEquals(sist.getUsuarios().size(), 3);
		// searchUsuario
		assertEquals(usuarioBuscado.getLogin(), "bb");
		// search pela posição
		assertEquals(sist.getUsuarios().get(2).getLogin(), "cc");
		// deletar
		sist.delUsuario("cc");
		assertEquals(sist.getUsuarios().size(), 2);
		
	}
}