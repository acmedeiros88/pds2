package enumOpc;

public enum Situacao {
	PRODUZIR("A produzir"),
	PRODUZIDO("Produzido"),
	FINALIZADO("Finalizado"),
	PARCIAL("Vendido parcial");

	private final String descricao;

	Situacao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
