package Enums;

public enum ETipoPagamento {
	
	PIX("PIX"),
    DEBITO("Debito"),
    CREDITO("Credito"),
	ESTORNO("Estorno");

    private String descricao;

    ETipoPagamento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
