package controller;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
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
	
	public Acomodacao getAcomodacao(String numeroQuarto) throws NumberFormatException {
		try {
			int numero = Integer.parseInt(numeroQuarto);
			return acomodacao.get(numero);
			
		} catch (NumberFormatException e) {
			throw new NumberFormatException("O numero do quarto digitado nao e um numero valido.");
		}
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
	
	public String[][] getDisponibilidade(String ocupantes) throws NumberFormatException {
		List<String[]> linhaElementos = new ArrayList<>();
		try {
			int numeroOcupantes = Integer.parseInt(ocupantes);
			for (Acomodacao quarto : acomodacao.values()) {
				if(quarto.getOcupacaoMaxima() >= numeroOcupantes && quarto.getEstadoOcupacao() == EEstadoOcupacao.DISPONIVEL) {
					String[] linha = {String.valueOf(quarto.getNumero()), String.valueOf(quarto.getOcupacaoMaxima()), String.valueOf(quarto.getTarifaDiaria()), String.valueOf(quarto.getAdicionalAcompanhante())};
					linhaElementos.add(linha);
				}
			}
			String[][] matrizElementos = new String[linhaElementos.size()][];
			linhaElementos.toArray(matrizElementos);
						
			return matrizElementos;
			
		}catch(NumberFormatException e) {
			throw new NumberFormatException("O numero de ocupantes nao e um valor valido.");
		}catch(NullPointerException e) {
			throw new NullPointerException();
		}
	}
	
	public void setStatus(String numeroString, boolean b) throws NumberFormatException {
		
		try {
			if(b == true){
				getAcomodacao(numeroString).setEstadoOcupacao(EEstadoOcupacao.MANUTENCAO);
			}else {
				getAcomodacao(numeroString).setEstadoOcupacao(EEstadoOcupacao.DISPONIVEL);
			}
			
		} catch (NumberFormatException e) {
			throw e;
		}
	}
	
}
