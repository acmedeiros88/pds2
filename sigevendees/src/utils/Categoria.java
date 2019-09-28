package utils;

public enum Categoria {
	
	INGREDIENTE("Ingrediente"),
	BOLO("Bolo"),
	EMBALAGEM("Embalagem"),
	SALGADO("Salgado");

	private String descricao;

	private Categoria(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
