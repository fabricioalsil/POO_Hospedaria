package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import enums.EEstadoOcupacao;
import enums.ETipoPagamento;
import models.Acomodacao;
import models.Hospedagem;
import models.Hospede;

public class HospedagemController implements Serializable {

	private static final long serialVersionUID = -2986449868123120251L;
	
	private Map<Integer, ArrayList<Hospedagem>> hospedagem;
	private Map<Long, Hospede> hospedes;
	
	public HospedagemController() {
		hospedagem = new TreeMap<>();
		hospedes = new TreeMap<>();
	}
	
	public void addHospedagem(String numeroAcomodacaoString, String cpfString, String nome, String email, String telefoneString, boolean primeiroHospede) throws NumberFormatException, NullPointerException {
		
		int numeroAcomodacao = Integer.parseInt(numeroAcomodacaoString);
		
		if(primeiroHospede == true) {	
			try {
				Acomodacao quarto = MainController.getAcomodacaoController().getAcomodacao(numeroAcomodacaoString);
				
				try {
					Hospede newHospede = addHospede(cpfString, nome, email, telefoneString);
					Hospedagem newHospedagem = new Hospedagem(newHospede, quarto);
					if(hospedagem.get(numeroAcomodacao) == null) {
						ArrayList<Hospedagem> lista = new ArrayList<Hospedagem>();
						lista.add(newHospedagem);
						hospedagem.put(numeroAcomodacao, lista);
						
					}else {
						hospedagem.get(numeroAcomodacao).add(newHospedagem);
					}
					quarto.setEstadoOcupacao(EEstadoOcupacao.OCUPADO);
										
				} catch (NumberFormatException e) {
					throw e;
				}
			} catch (NumberFormatException e) {
				throw new NumberFormatException("Confira os campos preenchidos e tente novamente");
			}
		}else {
			try {
				Hospede acompanhante = addHospede(cpfString, nome, email, telefoneString);		
				
				//Pede ao Map hospedagem, o Array de hospedagens do quarto com numero numeroAcomodacao
				//Acessa e adiciona o acompanhante na ultima posição
				hospedagem.get(numeroAcomodacao).get(hospedagem.get(numeroAcomodacao).size() -1).addAcompanhantes(acompanhante);
			} catch (NumberFormatException e) {
				throw e;
			}
		}
	}
	
	public Hospedagem getHospedagem(String numeroAcomodacaoString) throws NumberFormatException, NullPointerException {
		
		try {
			int numeroAcomodacao = Integer.parseInt(numeroAcomodacaoString);
			
			try {
				Hospedagem quarto = hospedagem.get(numeroAcomodacao).get(hospedagem.get(numeroAcomodacao).size() - 1);
				if( quarto.getDataCheckout() == null) {
					return quarto;
				}	
				
			}catch(NullPointerException e) {
				throw new NullPointerException("Hospedagem com conta aberta nao encontrada.");
			}
		}catch(NumberFormatException e) {
			throw new NumberFormatException("O numero do quarto digitado nao e um numero valido.");
		}
		
		return null;
	}
	
	public String getExtrato(Hospedagem quarto) {
		
		return quarto.extrato();
	}
	
	public Hospede addHospede(String cpfString, String nome, String email, String telefoneString) throws NumberFormatException {
		try {
			long cpf = Long.parseLong(cpfString);
			try {
				long telefone = Long.parseLong(telefoneString);
				Hospede newHospede = new Hospede(cpf, nome, email, telefone);
				hospedes.put(cpf, newHospede);
				return newHospede;
				
			}catch(NumberFormatException e) {
				throw new NumberFormatException("O telefone informado nao e valido, digite somente numeros");
			}
		}catch(NumberFormatException e) {
			throw new NumberFormatException("O cpf informado nao e valido, digite somente numeros");
		}
	}
	
	public Hospede getHospede(String cpfString) throws NumberFormatException {
		try {
			long cpf = Long.parseLong(cpfString);
			return hospedes.get(cpf);
			
		}catch(NumberFormatException e) {
			throw new NumberFormatException("O cpf informado nao e valido, digite somente numeros");
		}
	}
	
	public void cancelar(String numeroQuarto) {
		int numeroAcomodacao = Integer.parseInt(numeroQuarto);
		
		//Acessa a ultima posição do vetor hospedagem e a remove
		hospedagem.get(numeroAcomodacao).remove(hospedagem.get(numeroAcomodacao).size() -1);
	}

	public void addPagamento(String tipoPagamento, String text) {
		double valor = Double.parseDouble(text);
		ETipoPagamento tipo = ETipoPagamento.fromString(tipoPagamento);
		
		hospedagem.addPagamento(tipo, valor);
	}
}
