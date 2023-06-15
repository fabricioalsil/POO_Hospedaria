
public class TipoAcomodacao{
	private final String nome;
	private double tarifaDiaria;
	private double adicionalAcompanhante;
	
	public TipoAcomodacao(String nome, double tarifaDiaria, double adicionalAcompanhante) {
		this.nome = nome;
		this.tarifaDiaria = tarifaDiaria;
		this.adicionalAcompanhante = adicionalAcompanhante;
	}
	
	public String getNome() {
		return this.nome;
	}

	public double getTarifaDiaria() {
		return this.tarifaDiaria;
	}

	public void setTarifaDiaria(double tarifaDiaria) {
		this.tarifaDiaria = tarifaDiaria;
	}

	public double getAdicionalAcompanhante() {
		return this.adicionalAcompanhante;
	}

	public void setAdicionalAcompanhante(double adicionalAcompanhante) {
		this.adicionalAcompanhante = adicionalAcompanhante;
	}

	
	

}
