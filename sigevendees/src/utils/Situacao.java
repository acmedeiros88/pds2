package utils;

public enum Situacao {
	PRODUZIR("A produzir"),
	PRODUZIDO("Produzido"),
	FINALIZADO("Finalizado"),
	CANCELADO("Cancelado");

	private final String descricao;

	Situacao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
