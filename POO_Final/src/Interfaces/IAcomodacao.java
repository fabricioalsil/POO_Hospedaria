package Interfaces;
import Enums.EEstadoOcupacao;

public interface IAcomodacao {
	int getNumero();
	int getOcupacaoMaxima();
	void setEstadoOcupacao(EEstadoOcupacao e);
	String getTipo();
	double getTarifaDiaria();
	double getAdicionalAcompanhante();
}
