package controller;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.JOptionPane;

import Enums.EEstadoOcupacao;
import Models.Acomodacao;
import Models.TipoAcomodacao;

public class AcomodacaoController implements Serializable {

	private static final long serialVersionUID = -1737057782025884809L;
	
	private Map<String, TipoAcomodacao> tipoAcomodacao;
	private Map<Integer, Acomodacao> acomodacao;
	
	public AcomodacaoController() {
		tipoAcomodacao = new TreeMap<>();
		acomodacao = new TreeMap<>();
	}
	
	public void addAcomodacao (String numeroString, String ocupacaoMaxString, String nomeTipoString) throws NumberFormatException {
		
		TipoAcomodacao tipo = tipoAcomodacao.get(nomeTipoString);
		
		try {
			int numero = Integer.parseInt(numeroString);
			
			try {	
				int ocupacaoMax = Integer.parseInt(ocupacaoMaxString);
				Acomodacao newAcomodacao = new Acomodacao(numero, ocupacaoMax, EEstadoOcupacao.DISPONIVEL, tipo);
				acomodacao.put(newAcomodacao.getNumero(), newAcomodacao);
								
			} catch (NumberFormatException e) {
				throw new NumberFormatException("O numero de ocupacao maxima digitado nao e um numero valido.");
			}
		} catch (NumberFormatException e) {
			throw new NumberFormatException("O numero da acomodacao digitado nao e um numero valido.");
		}
		
		MainController.save();		
	}
	
	public Set<String> getTipoAcomodacao(){
		return tipoAcomodacao.keySet();
	}
	
}
