package br.usjt.projeto.dto;

import java.util.List;

public class FitaDTO {

	private List<CelulaDTO> celulas;
	private Integer indice;
	
	public List<CelulaDTO> getCelulas() {
		return celulas;
	}
	public void setCelulas(List<CelulaDTO> celulas) {
		this.celulas = celulas;
	}
	public Integer getIndice() {
		return indice;
	}
	public void setIndice(Integer indice) {
		this.indice = indice;
	}
	
	
}
