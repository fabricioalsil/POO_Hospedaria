package interfaces;
import enums.EEstadoOcupacao;

public interface IAcomodacao {
	int getNumero();
	int getOcupacaoMaxima();
	void setEstadoOcupacao(EEstadoOcupacao e);
	EEstadoOcupacao getEstadoOcupacao();
	String getTipo();
	double getTarifaDiaria();
	double getAdicionalAcompanhante();
}
