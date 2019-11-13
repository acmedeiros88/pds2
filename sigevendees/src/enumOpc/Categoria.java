package enumOpc;

public enum Categoria {
	
	INGREDIENTE("Ingrediente"),
	BOLO("Bolo"),
	EMBALAGEM("Embalagem"),
	SALGADO("Salgado");

	private String descricao;

	Categoria(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
