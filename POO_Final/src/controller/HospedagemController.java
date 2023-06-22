package controller;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

import models.Hospedagem;
import models.Hospede;

public class HospedagemController implements Serializable {

	private static final long serialVersionUID = -2986449868123120251L;
	
	private Map<Hospedagem, Integer> hospedagem;
	private Map<Long, Hospede> hospedes;
	
	public HospedagemController() {
		hospedagem = new TreeMap<>();
		hospedes = new TreeMap<>();
	}
	
	public Hospedagem getHospedagem(String numeroAcomodacaoString) throws NumberFormatException, NullPointerException {
		
		try {
			int numeroAcomodacao = Integer.parseInt(numeroAcomodacaoString);
			
			try {
				for (Hospedagem quarto : hospedagem.keySet()) {
					if(hospedagem.get(quarto) == numeroAcomodacao && quarto.getDataCheckout() == null) {
						return quarto;
					}
				}
				
			}catch(NullPointerException e) {
				throw new NullPointerException("Nenhuma hospedagem foi cadastrada");
			}
		}catch(NumberFormatException e) {
			throw new NumberFormatException("O numero do quarto digitado nao e um numero valido.");
		}
		
		return null;
	}
	
	public String getExtrato(Hospedagem quarto) {
		
		return quarto.getExtrato();
	}
	
	public void addHospede(String cpfString, String nome, String email, String telefoneString) throws NumberFormatException {
		try {
			long cpf = Integer.parseInt(cpfString);
			try {
				long telefone = Integer.parseInt(telefoneString);
				Hospede newHospede = new Hospede(cpf, nome, email, telefone);
				hospedes.put(cpf, newHospede);
				
			}catch(NumberFormatException e) {
				throw new NumberFormatException("O telefone informado nao e valido, digite somente numeros");
			}
		}catch(NumberFormatException e) {
			throw new NumberFormatException("O cpf informado nao e valido, digite somente numeros");
		}
	}
	
	public Hospede getHospede(String cpfString) throws NumberFormatException {
		try {
			long cpf = Integer.parseInt(cpfString);
			return hospedes.get(cpf);
			
		}catch(NumberFormatException e) {
			throw new NumberFormatException("O cpf informado nao e valido, digite somente numeros");
		}
	}
}
