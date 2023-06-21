package controller;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import enums.EEstadoOcupacao;
import models.Acomodacao;
import models.TipoAcomodacao;

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
				acomodacao.put(numero, newAcomodacao);
								
			} catch (NumberFormatException e) {
				throw new NumberFormatException("O numero de ocupacao maxima digitado nao e um numero valido.");
			}
		} catch (NumberFormatException e) {
			throw new NumberFormatException("O numero da acomodacao digitado nao e um numero valido.");
		}
		
		MainController.save();		
	}
	
	public void addTipoAcomodacao(String nome, String tarifaDiariaString, String adicionalAcompanhanteString) throws NumberFormatException, Exception {
		
		if(tipoAcomodacao.get(nome) != null) {
			
			try {
				double tarifaDiaria = Double.parseDouble(tarifaDiariaString);
				
				//Formatacao para 0.00
				DecimalFormat decimalFormat = new DecimalFormat("0.00");
                String valorFormatado = decimalFormat.format(tarifaDiaria);
                NumberFormat numberFormat = NumberFormat.getInstance();
                double tarifaDiariaFormatado = numberFormat.parse(valorFormatado).doubleValue();
				
				try {	
					double adicionalAcompanhante = Double.parseDouble(adicionalAcompanhanteString);
					
					//Formatacao para 0.00
					valorFormatado = decimalFormat.format(adicionalAcompanhante);
					double adicionalAcompanhanteFormatado = numberFormat.parse(valorFormatado).doubleValue();
					
					TipoAcomodacao newTipoAcomodacao = new TipoAcomodacao(nome, tarifaDiariaFormatado, adicionalAcompanhanteFormatado);
					tipoAcomodacao.put(nome, newTipoAcomodacao);
									
				} catch (NumberFormatException e) {
					throw new NumberFormatException("O valor de adicional por acompanhante digitado nao e um numero valido.");
				}
			} catch (NumberFormatException e) {
				throw new NumberFormatException("O valor da diaria digitado nao e um numero valido.");
			}
			
			MainController.save();			
		}	
	}
	
	public Set<String> getTipoAcomodacao(){
		return tipoAcomodacao.keySet();
	}
	
}
