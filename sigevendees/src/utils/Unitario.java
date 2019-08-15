package utils;

public enum Unitario {
	G("gramas"), Ml("mililitros"), UND("unidade");

	private String descricao;

	private Unitario(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
