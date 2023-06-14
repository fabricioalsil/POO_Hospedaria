
public enum ETipoPagamento {
	
	PIX("PIX"),
    DEBITO("Debito"),
    CREDITO("Credito");

    private String descricao;

    ETipoPagamento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
