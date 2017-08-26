package hello;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Venda {
	private Float valortotal;
	private String formapagto;
	private LocalDate datavenda;
	private int codigo;
	private List<Produto> produtos = new LinkedList<Produto>();
	
	public Venda(Float valortotal, String formapagto, LocalDate datavenda, int codigo, List<Produto> produtos){
		this.valortotal = valortotal;
		this.formapagto = formapagto;
		this.datavenda = datavenda;
		this.codigo = codigo;
		this.produtos = produtos;
	}

	//Valor Total
	public Float getValortotal() {
		return valortotal;
	}

	public void setValortotal(Float valortotal) {
		this.valortotal = valortotal;
	}

	//Forma de Pagamento
	public String getFormapagto() {
		return formapagto;
	}

	public void setFormapagto(String formapagto) {
		this.formapagto = formapagto;
	}

	//Data de Venda
	public LocalDate getDatavenda() {
		return datavenda;
	}

	public void setDatavenda(LocalDate datavenda) {
		this.datavenda = datavenda;
	}

	//Códigos
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	//Produtos
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public void addProduto(Produto prod){
		produtos.add(prod);
	}
	
	public void delProduto(int codigoproduto){
		for(Produto prod:produtos){
			if(prod.getCodigoproduto()==codigoproduto) produtos.remove(prod);
		}
	}
}
