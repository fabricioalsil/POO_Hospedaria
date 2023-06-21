package models;
import java.io.Serializable;

import interfaces.IHospede;

public class Hospede implements IHospede, Serializable {
	
	private static final long serialVersionUID = -7355236476749803907L;
	
	private final long cpf;
	private String nome;
	private String email;
	private long telefone;
	
	public Hospede(long cpf, String nome, String email, long telefone) {
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
	}
	
	public long getCpf() {
		return this.cpf;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getTelefone() {
		return this.telefone;
	}

	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}
	
	public String toString() {
		return "CPF: " + getCpf() + "   Nome: " + getNome();
	}
	
}
