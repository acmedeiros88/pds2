package utils;

public enum Categoria {
	BOLO("bolo"), SALGADO("salgado"), INGREDIENTE("ingrediente"), EMBALAGEM("embalagem");

	private String descricao;

	private Categoria(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
