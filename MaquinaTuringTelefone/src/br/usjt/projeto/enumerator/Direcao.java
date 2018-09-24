package br.usjt.projeto.enumerator;

public enum Direcao {
	
	DIREITA("direita"),
	ESQUERDA("esquerda");
	
	private Direcao(String direcao) {
		this.direcao = direcao;
	}
	
	private String direcao;
	
	public String getDirecao() {
		return direcao;
	}

}
