
public class Acomodacao implements IAcomodacao{
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

	@Override
	public int getNumero() {
		return this.numero;
	}

	@Override
	public int getOcupacaoMaxima() {
		return this.ocupacaoMax;
	}

	public EEstadoOcupacao getEstadoOcupacao() {
		return this.estadoOcupacao;
	}
	
	@Override
	public void setEstadoOcupacao(EEstadoOcupacao e) {
		this.estadoOcupacao = e;		
	}
	
	@Override
	public String getTipo() {
		return this.tipo.getNome();
	}

	public void setTipo(TipoAcomodacao tipo) {
		this.tipo = tipo;
	}

	@Override
	public double getTarifaDiaria() {
		return this.tipo.getTarifaDiaria();
	}

	@Override
	public double getAdicionalAcompanhante() {
		return this.tipo.getAdicionalAcompanhante();
	}

	
	
}
