package Models;
import java.util.ArrayList;
import java.util.Date;

import Interfaces.IAcomodacao;
import Interfaces.IHospede;

public class Checkin {
	private final Date data;
	private IHospede hospedePrincipal;
	private ArrayList<IHospede> acompanhantes = new ArrayList<>();
	private IAcomodacao quarto;
	
	public Checkin(Date data, IHospede hospedePrincipal, IAcomodacao quarto) {
		this.data = new Date();
		this.hospedePrincipal = hospedePrincipal;
		this.quarto = quarto;
	}

	public Date getData() {
		return data;
	}

	public IHospede getHospedePrincipal() {
		return hospedePrincipal;
	}

	public void setHospedePrincipal(IHospede hospedePrincipal) {
		this.hospedePrincipal = hospedePrincipal;
	}
	
	public void addAcompanhantes(IHospede h) {
		this.acompanhantes.add(h);
	}
	
	//TODO verificar se é assim mesmo
	public void removeAcompanhantes(IHospede h) {
		this.acompanhantes.remove(h);
	}

	public IAcomodacao getQuarto() {
		return quarto;
	}

	public void setQuarto(IAcomodacao quarto) {
		this.quarto = quarto;
	}
	
	public StringBuilder listar() {
		StringBuilder listaHospedes = new StringBuilder();
		
		listaHospedes.append(getHospedePrincipal().toString()).append("\n");
		
		for(IHospede lista : acompanhantes) {
			listaHospedes.append(lista.toString()).append("\n");
		}
		
		return listaHospedes;
	}
		
}
