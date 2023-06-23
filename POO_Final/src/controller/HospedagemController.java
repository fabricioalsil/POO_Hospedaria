package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import enums.EEstadoOcupacao;
import enums.ETipoPagamento;
import exception.EEstadoOcupacaoException;
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
	
	public void addHospedagem(String numeroAcomodacaoString, String cpfString, String nome, String telefoneString, String email, boolean primeiroHospede) throws NumberFormatException, NullPointerException, EEstadoOcupacaoException {
		
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
										
				} catch (NumberFormatException e) {
					throw e;
				} catch (EEstadoOcupacaoException e) {
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
		
		MainController.save();
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
		Hospedagem quarto = hospedagem.get(numeroAcomodacao).get(hospedagem.get(numeroAcomodacao).size() -1);
		hospedagem.get(numeroAcomodacao).remove(hospedagem.get(numeroAcomodacao).size() -1);
		
		quarto.getQuarto().setEstadoOcupacao(EEstadoOcupacao.DISPONIVEL);
		MainController.save();
		
	}

	public void addPagamento(Hospedagem quarto, String tipoPagamento, String valorString) throws NumberFormatException {
		
		try{
			double valor = Double.parseDouble(valorString);
			ETipoPagamento tipo = ETipoPagamento.fromString(tipoPagamento);
			
			quarto.addPagamento(tipo, valor);
		}catch(NumberFormatException e) {
			throw new NumberFormatException("O numero escrito no campo valor e invalido.");
		}		
		
		MainController.save();
	}
	
	public void comprar(Hospedagem hospedagem, String codigoString, String qtd) throws NumberFormatException {
		
		long codigo = Long.parseLong(codigoString);
		
		try {
			int quantidade = Integer.parseInt(qtd);
			if(quantidade < 1) {
				throw new NumberFormatException("");
			}
			
			CatalogoController catalogoController = MainController.getCatalogoController();
			hospedagem.getConta().addItem(catalogoController.getItem(codigo), quantidade);
			
		}catch(NumberFormatException e) {
			throw new NumberFormatException("");
		}		
		
		MainController.save();
	}
}
