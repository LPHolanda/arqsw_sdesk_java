package br.usjt.projeto.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.usjt.projeto.enumerator.Direcao;

@Entity
public class Celula {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cdCelula;
	
	private Integer indice;

	private String estado;

	private Direcao direcao;

	public Celula() {

	}

	public Celula(Integer indice, String estado, Direcao direcao) {
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

	public Integer getCdCelula() {
		return cdCelula;
	}

	public void setCdCelula(Integer cdCelula) {
		this.cdCelula = cdCelula;
	}

	@Override
	public String toString() {
		return "Celula [indice=" + indice + ", estado=" + estado + ", direcao=" + direcao + "]";
	}

}
