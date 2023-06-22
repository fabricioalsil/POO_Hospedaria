package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;

import enums.ETipoPagamento;
import interfaces.IAcomodacao;
import interfaces.IConta;
import interfaces.IHospede;

public class Hospedagem implements Serializable{
	
	private static final long serialVersionUID = -8491283020138955700L;
	
	//constantes
	private final static int INICIO_CHECKIN = 13;
	private final static int LIMITE_CHECKOUT = 12;
	
	//variaveis
	private final String id;
	private final Calendar dataCheckin;
	private Calendar dataCheckout = null;
	private IHospede hospede;
	private ArrayList<IHospede> acompanhantes = new ArrayList<>();
	private IAcomodacao quarto;
	private final IConta conta;
	private ArrayList<Pagamento> pagamento = new ArrayList<>();
	
	public Hospedagem(IHospede hospede, IAcomodacao quarto) {
		this.id = UUID.randomUUID().toString();
		this.dataCheckin = Calendar.getInstance();
		this.hospede = hospede;
		this.quarto = quarto;
		this.conta = new Conta();
	}
	
	public String getId() {
		return id;
	}
		
	public Calendar getDataCheckin() {
		return dataCheckin;
	}

	public Calendar getDataCheckout() {
		return dataCheckout;
	}

	public void setDataCheckout(Calendar dataCheckout) {
		this.dataCheckout = dataCheckout;
	}

	public IHospede getHospede() {
		return hospede;
	}

	public void setHospede(IHospede hospede) {
		this.hospede = hospede;
	}

	public void addAcompanhantes(IHospede acompanhante) {
		acompanhantes.add(acompanhante);
	}

	public IAcomodacao getQuarto() {
		return quarto;
	}

	public void setQuarto(IAcomodacao quarto) {
		this.quarto = quarto;
	}

	public IConta getConta() {
		return conta;
	}

	public void addPagamento(ETipoPagamento tipo, double valor) {
		if(tipo == ETipoPagamento.ESTORNO) {
			valor = -valor;
		}
		pagamento.add(new Pagamento(tipo, valor));
	}
	
	public int numDiarias() {
		int numDiarias = 0;
		
		Calendar dataHoje = Calendar.getInstance();

		int hora = dataHoje.get(Calendar.HOUR_OF_DAY);
		int dia = dataHoje.get(Calendar.DAY_OF_YEAR);
		
		numDiarias = dia - getDataCheckin().get(Calendar.DAY_OF_YEAR);
		
		if(hora > getLimitecheckout()) {
			++numDiarias;
		}
				
		return numDiarias;
	}
		
	public double valorTotalDiarias() {
		double total = 0;
				
		total = numDiarias()*(getQuarto().getTarifaDiaria() + getQuarto().getAdicionalAcompanhante()*acompanhantes.size());
				
		return total;
	}
	
	public double totalPagamentos() {
		double total = 0;
		
		for(Pagamento pgto: pagamento) {
			total += pgto.getValor();
		}
		
		return total;
	}
	
	public double saldoDevedor() {
		double saldoDevedor = 0;
		
		saldoDevedor = valorTotalDiarias() + conta.getTotal() - totalPagamentos();
		
		return saldoDevedor;
	}
	
	public StringBuilder listarPagamentos() {
		StringBuilder listarPgtos = new StringBuilder();
		
		for(Pagamento pgto : pagamento){
			listarPgtos.append("Data: ").append(pgto.getData()).append("\t");
			listarPgtos.append(pgto.getTipo()).append(" R$ ");
			listarPgtos.append(pgto.getValor()).append("\n");
		}
		
		listarPgtos.append("> SUBTOTAL: R$" + totalPagamentos() + "\n");
				
		return listarPgtos;
	}
	
	public String extrato() {
		StringBuilder extrato = new StringBuilder();
		
		extrato.append("DIARIAS: \n");
		extrato.append("Quantidade: " + numDiarias() + "\n");
		extrato.append("Preço: R$" + getQuarto().getTarifaDiaria() + "\n");
		extrato.append("Adicional Acompanhante: R$" + getQuarto().getAdicionalAcompanhante() + "\n");
		extrato.append("> SUBTOTAL: R$" + valorTotalDiarias() + "\n\n");
		
		extrato.append("DESPESAS DE HOSPEDAGEM: \n");
		extrato.append(getConta().listar()).append("\n");
		
		extrato.append("PAGAMENTOS REALIZADOS: \n");
		extrato.append(listarPagamentos()).append("\n");
		
		extrato.append(">>> TOTAL = R$" + saldoDevedor() + "\n");
				
		return extrato.toString();
	}
	
	//Checkout
	public void checkout() {
		setDataCheckout(Calendar.getInstance());
	}

	//Métodos da classe
	public static int getIniciocheckin() {
		return INICIO_CHECKIN;
	}

	public static int getLimitecheckout() {
		return LIMITE_CHECKOUT;
	}

}
