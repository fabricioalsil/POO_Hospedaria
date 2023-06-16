package Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import Enums.ETipoPagamento;
import Interfaces.IAcomodacao;
import Interfaces.IConta;
import Interfaces.IHospede;

//AHHHHHHHHHHHHHHHHHHHHHHHHHHHHH
public class Hospedagem implements Serializable{
	
	private static final long serialVersionUID = -8491283020138955700L;
	private final static int inicioCheckin = 13;
	private final static int limiteCheckout = 12;
	private final String id;
	private final Date dataCheckin;
	private Date dataCheckout;
	private IHospede hospede;
	private ArrayList<IHospede> acompanhantes = new ArrayList<>();
	private IAcomodacao quarto;
	private final IConta conta;
	private ArrayList<Pagamento> pagamento = new ArrayList<>();
	
	public Hospedagem(IHospede hospede, IAcomodacao quarto) {
		this.id = UUID.randomUUID().toString();
		this.dataCheckin = new Date();
		this.hospede = hospede;
		this.quarto = quarto;
		this.conta = new Conta();
	}
	
	public Date getDataCheckin() {
		return dataCheckin;
	}

	public Date getDataCheckout() {
		return dataCheckout;
	}

	public void setDataCheckout(Date dataCheckout) {
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
		pagamento.add(new Pagamento(tipo, valor));
	}
	
	public void addEstorno(double valor) {
		pagamento.add(new Pagamento(ETipoPagamento.ESTORNO, -valor));
	}
	
	public String getId() {
		return id;
	}

	//Métodos da classe
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static int getIniciocheckin() {
		return inicioCheckin;
	}

	public static int getLimitecheckout() {
		return limiteCheckout;
	}

	


	
	
	
	
	
	
}
