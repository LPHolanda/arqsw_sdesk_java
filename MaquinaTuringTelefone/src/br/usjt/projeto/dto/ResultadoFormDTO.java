package br.usjt.projeto.dto;

public class ResultadoFormDTO {
	
	private String identificacao;
	private String telefone;
	private String msg;
	private String destinoRegiao;
	

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getIdentificacao() {
		return identificacao;
	}

	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}

	public String getDestinoRegiao() {
		return destinoRegiao;
	}

	public void setDestinoRegiao(String destinoRegiao) {
		this.destinoRegiao = destinoRegiao;
	}

	@Override
	public String toString() {
		return "ResultadoFormDTO [identificacao=" + identificacao + ", telefone=" + telefone + ", msg=" + msg
				+ ", destinoRegiao=" + destinoRegiao + "]";
	}

	
	
	

}
