package hello;

import java.time.LocalDate;

public class Cliente {
	private int codigocliente;
	private String nomecliente;
	private String cpf;
	private String enderecocliente;
	private String telefone;
	private LocalDate datacad;
	
	public Cliente(int codigocliente, String nomecliente, String cpf, String enderecocliente, String telefone, LocalDate datacad){
		this.codigocliente = codigocliente;
		this.nomecliente = nomecliente;
		this.cpf = cpf;
		this.enderecocliente = enderecocliente;
		this.telefone = telefone;
		this.datacad = datacad;
	}

	public int getCodigocliente() {
		return codigocliente;
	}

	public void setCodigocliente(int codigocliente) {
		this.codigocliente = codigocliente;
	}

	public String getNomecliente() {
		return nomecliente;
	}

	public void setNomecliente(String nomecliente) {
		this.nomecliente = nomecliente;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEnderecocliente() {
		return enderecocliente;
	}

	public void setEnderecocliente(String enderecocliente) {
		this.enderecocliente = enderecocliente;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public LocalDate getDatacad() {
		return datacad;
	}

	public void setDatacad(LocalDate datacad) {
		this.datacad = datacad;
	}
	
}
