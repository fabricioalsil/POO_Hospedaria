package controller;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

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
	
	public void addAcomodacao(int numero, int ocupacaoMax, String nomeTipo) {
		
		TipoAcomodacao tipo = tipoAcomodacao.get(nomeTipo);
		
		Acomodacao newAcomodacao = new Acomodacao(numero, ocupacaoMax, EEstadoOcupacao.DISPONIVEL, tipo);
		acomodacao.put(newAcomodacao.getNumero(), newAcomodacao);
		
	}
	
	public Set<String> getTipoAcomodacao(){
		return tipoAcomodacao.keySet();
	}
	
}
