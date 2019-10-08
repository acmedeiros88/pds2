package utils;

public enum Situacao {
	PRODUZIR("a Produzir"),
	PRODUZIDO("Produzido"),
	EFETUADO("Efetuado"),
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
