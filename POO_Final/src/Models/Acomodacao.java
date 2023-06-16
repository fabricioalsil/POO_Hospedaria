package Models;
import java.io.Serializable;

import Enums.EEstadoOcupacao;
import Interfaces.IAcomodacao;

public class Acomodacao implements IAcomodacao, Serializable {
	
	private static final long serialVersionUID = 8480015296174609482L;
	
	private final int numero;
	private final int ocupacaoMax;
	private EEstadoOcupacao estadoOcupacao;
	private TipoAcomodacao tipo;
	
	public Acomodacao(int numero, int ocupacaoMax, EEstadoOcupacao estadoOcupacao, TipoAcomodacao tipo) {
		this.numero = numero;
		this.ocupacaoMax = ocupacaoMax;
		this.estadoOcupacao = estadoOcupacao;
		this.tipo = tipo;
	}

	public int getNumero() {
		return numero;
	}

	public int getOcupacaoMaxima() {
		return ocupacaoMax;
	}

	public EEstadoOcupacao getEstadoOcupacao() {
		return estadoOcupacao;
	}
	
	public void setEstadoOcupacao(EEstadoOcupacao e) {
		this.estadoOcupacao = e;		
	}
	
	public String getTipo() {
		return this.tipo.getNome();
	}

	public void setTipo(TipoAcomodacao tipo) {
		this.tipo = tipo;
	}

	public double getTarifaDiaria() {
		return this.tipo.getTarifaDiaria();
	}

	public double getAdicionalAcompanhante() {
		return this.tipo.getAdicionalAcompanhante();
	}


	
	
}
