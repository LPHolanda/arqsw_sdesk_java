package br.usjt.projeto.dto;

import br.usjt.projeto.enumerator.Direcao;

public class CelulaDTO {

	private Integer indice;
	private String estado;
	private Direcao direcao;

	public CelulaDTO() {
		super();
	}

	public CelulaDTO(Integer indice, String estado, Direcao direcao) {
		super();
		this.indice = indice;
		this.estado = estado;
		this.direcao = direcao;
	}

	public Integer getIndice() {
		return indice;
	}

	public void setIndice(Integer indice) {
		this.indice = indice;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Direcao getDirecao() {
		return direcao;
	}

	public void setDirecao(Direcao direcao) {
		this.direcao = direcao;
	}

	@Override
	public String toString() {
		return "Celula [indice=" + indice + ", estado=" + estado + ", direcao=" + direcao + "]";
	}

}
