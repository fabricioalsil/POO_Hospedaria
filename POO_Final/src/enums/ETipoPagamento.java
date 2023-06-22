package enums;

public enum ETipoPagamento {
	
	PIX("PIX"),
    DEBITO("Débito"),
    CREDITO("Crédito"),
	ESTORNO("Estorno");

    private String descricao;

    ETipoPagamento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public static ETipoPagamento fromString(String descricao) {
        for (ETipoPagamento tipo : ETipoPagamento.values()) {
            if (tipo.descricao.equalsIgnoreCase(descricao)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Tipo de pagamento inválido: " + descricao);
    }
}
