package controller;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

import models.Hospedagem;

public class HospedagemController implements Serializable {

	private static final long serialVersionUID = -2986449868123120251L;
	
	private Map<Hospedagem, Integer> hospedagem;
	
	public HospedagemController() {
		hospedagem = new TreeMap<>();
		
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
	
	
}
