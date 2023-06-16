package Models;

import java.util.Date;

import Interfaces.IAcomodacao;
import Enums.EEstadoOcupacao;

public class Checkout {
	private final Date data;
	private IAcomodacao quarto;
	
	public Checkout(Date data, IAcomodacao quarto) {
		this.data = new Date();
		this.quarto = quarto;
	}
	
	public Date getData() {
		return data;
	}

	public IAcomodacao getQuarto() {
		return quarto;
	}

	public void setQuarto(IAcomodacao quarto) {
		this.quarto = quarto;
	}	
	
	public void setEstadoQuarto() {
		this.quarto.setEstadoOcupacao(EEstadoOcupacao.MANUTENCAO);
	}
}
