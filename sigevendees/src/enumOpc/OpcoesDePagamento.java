package enumOpc;

public enum OpcoesDePagamento {
	DINHEIRO("Dinheiro"),
	CREDITO("Cartão Credito"),
	DEBITO("Cartão Debito"),
	PRAZO("a Prazo");

	private final String descricao;

	OpcoesDePagamento(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
