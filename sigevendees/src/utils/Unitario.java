package utils;

public enum Unitario {
	G("Gramas"),
	ML("Mililitros"),
	UND("Unidade");

	private final String descricao;

	Unitario(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
