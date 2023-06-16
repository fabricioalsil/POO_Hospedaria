package Models;
import Interfaces.IHospede;

public class Hospede implements IHospede{
	private final long cpf;
	private String nome;
	private String email;
	private long telefone;
	
	public Hospede(long cpf, String nome, String email, long telefone) {
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
	}
	
	@Override
	public long getCpf() {
		return this.cpf;
	}

	@Override
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
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
