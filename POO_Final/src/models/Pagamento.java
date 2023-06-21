package models;
import java.io.Serializable;
import java.util.Date;

import enums.ETipoPagamento;

public class Pagamento implements Serializable{
	
	private static final long serialVersionUID = 1141626869140998524L;
	
	private final ETipoPagamento tipo;
	private final Date data;
	private final double valor;
	
	public Pagamento(ETipoPagamento tipo, double valor) {
		this.tipo = tipo;
		this.data = new Date();
		this.valor = valor;
	}

	public ETipoPagamento getTipo() {
		return tipo;
	}

	public Date getData() {
		return data;
	}

	public double getValor() {
		return valor;
	}
		
}
