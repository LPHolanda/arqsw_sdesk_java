package br.usjt.projeto.entity;

import java.util.Arrays;
import java.util.List;

import br.usjt.projeto.dto.CelulaDTO;
import br.usjt.projeto.dto.ResultadoFormDTO;
import br.usjt.projeto.enumerator.Direcao;
import br.usjt.projeto.enumerator.NumeroGeograficos;

public class MaquinaTuring {

	public static MaquinaTuring maquina;

	private static final List<String> NUMEROS_GEOGRAFICO_DA_FRANCA = Arrays.asList("1", "2", "3", "4", "5");

	private StringBuilder telefone = new StringBuilder("");

	private MaquinaTuring() {

	}

	public static MaquinaTuring getInstance() {
		if (maquina != null) {
			return maquina;
		}
		return new MaquinaTuring();
	}

	public void lerFita(ResultadoFormDTO result, List<CelulaDTO> fita, Integer indice) {
		if (fita.size() - 1 == 10) {

			String label = "Ligação França para França";
			result.setIdentificacao(label);

			ligacaoFrancaToFranca(result, fita, indice);
		} else if (fita.size() - 1 > 10) {

			String label = "Ligação Brasil para França";
			result.setIdentificacao(label);

			ligacaoBrasilToFranca(result, fita, indice);
		} else {

			String label = "Chamada inválida";
			result.setIdentificacao(label);
		}
	}

	private void ligacaoBrasilToFranca(ResultadoFormDTO result, List<CelulaDTO> fita, Integer indice) {
		CelulaDTO celula = fita.get(indice);
		if (indice != null && celula != null) {
			if (!"".equals(celula.getEstado())) {
				if ((indice.equals(0) || indice.equals(1)) && "0".equals(celula.getEstado())) {
					printEstadoBrasilToFranca(result, fita, indice, celula);
				} else if ((indice.equals(2) || indice.equals(3)) && "5".equals(celula.getEstado())) {
					printEstadoBrasilToFranca(result, fita, indice, celula);
				} else if ((indice.equals(4) || indice.equals(5)) && "3".equals(celula.getEstado())) {
					printEstadoBrasilToFranca(result, fita, indice, celula);
				} else if (indice.equals(6) && NUMEROS_GEOGRAFICO_DA_FRANCA.contains(celula.getEstado())) {
					printEstadoBrasilToFranca(result, fita, indice, celula);
				} else if (indice > 6) {
					printEstadoBrasilToFranca(result, fita, indice, celula);
				} else {
					telefone.append(celula.getEstado());

					result.setTelefone(telefone.toString());
					result.setMsg("Discagem Incorreta");
				}
			} else {
				if (telefone.toString().length() > 10) {

					result.setMsg("Discagem Finalizada");
					result.setTelefone(telefone.toString());

				} else {

					result.setMsg("Discagem Incorreta");
					result.setTelefone(telefone.toString());

				}
			}
		} else {

			result.setMsg("Discagem Finalizada");

		}
	}

	private void ligacaoFrancaToFranca(ResultadoFormDTO result, List<CelulaDTO> fita, Integer indice) {
		CelulaDTO celula = fita.get(indice);
		if (indice != null && celula != null) {
			if (!"".equals(celula.getEstado())) {
				if (indice.equals(0) && "0".equals(celula.getEstado())) {
					printEstadoFrancaToFranca(result, fita, indice, celula);
				} else if (indice.equals(1) && NUMEROS_GEOGRAFICO_DA_FRANCA.contains(celula.getEstado())) {
					printEstadoFrancaToFranca(result, fita, indice, celula);
				} else if (indice > 1) {
					printEstadoFrancaToFranca(result, fita, indice, celula);
				} else {
					telefone.append(celula.getEstado());

					result.setMsg("Discagem Incorreta");
					result.setTelefone(telefone.toString());

				}
			} else {
				if (telefone.toString().length() == 10) {

					System.out.println(printRegiaoLigacao(result, telefone.toString(), false));

					result.setIdentificacao(printRegiaoLigacao(result, telefone.toString(), false));
					result.setMsg("Discagem Finalizada");
					result.setTelefone(telefone.toString());
				} else {

					result.setMsg("Discagem Incorreta");
					result.setTelefone(telefone.toString());
				}
			}
		} else {
			result.setMsg("Discagem Finalizada");

		}
	}

	private void printEstadoFrancaToFranca(ResultadoFormDTO result, List<CelulaDTO> fita, Integer indice,
			CelulaDTO celula) {
		telefone.append(celula.getEstado());
		ligacaoFrancaToFranca(result, fita, verificaDirecao(celula, indice));
	}

	private void printEstadoBrasilToFranca(ResultadoFormDTO result, List<CelulaDTO> fita, Integer indice,
			CelulaDTO celula) {
		telefone.append(celula.getEstado());
		ligacaoBrasilToFranca(result, fita, verificaDirecao(celula, indice));
	}

	private Integer verificaDirecao(CelulaDTO celula, Integer indice) {
		if (celula.getDirecao().equals(Direcao.DIREITA)) {
			return indice + 1;
		} else {
			return indice - 1;
		}
	}

	private String printRegiaoLigacao(ResultadoFormDTO result, String telefone, boolean isInternacional) {
		if (isInternacional) {
			switch (telefone.substring(6, 7)) {
			case "1":

				result.setDestinoRegiao("Chamada do Brasil para " + NumeroGeograficos.ZERO_UM.getRegiao());
				return "Chamada do Brasil para " + NumeroGeograficos.ZERO_UM.getRegiao();

			case "2":

				result.setDestinoRegiao("Chamada do Brasil para " + NumeroGeograficos.ZERO_DOIS.getRegiao());
				return "Chamada do Brasil para " + NumeroGeograficos.ZERO_DOIS.getRegiao();

			case "3":

				result.setDestinoRegiao("Chamada do Brasil para " + NumeroGeograficos.ZERO_TRES.getRegiao());
				return "Chamada do Brasil para " + NumeroGeograficos.ZERO_TRES.getRegiao();

			case "4":

				result.setDestinoRegiao("Chamada do Brasil para " + NumeroGeograficos.ZERO_QUATRO.getRegiao());
				return "Chamada do Brasil para " + NumeroGeograficos.ZERO_QUATRO.getRegiao();

			case "5":

				result.setDestinoRegiao("Chamada do Brasil para " + NumeroGeograficos.ZERO_CINCO.getRegiao());
				return "Chamada do Brasil para " + NumeroGeograficos.ZERO_CINCO.getRegiao();
			}
		} else {
			switch (telefone.substring(1, 2)) {
			case "1":
				result.setDestinoRegiao(NumeroGeograficos.ZERO_UM.getRegiao());
				return NumeroGeograficos.ZERO_UM.getRegiao();

			case "2":
				result.setDestinoRegiao(NumeroGeograficos.ZERO_DOIS.getRegiao());
				return NumeroGeograficos.ZERO_DOIS.getRegiao();

			case "3":
				result.setDestinoRegiao(NumeroGeograficos.ZERO_TRES.getRegiao());
				return NumeroGeograficos.ZERO_TRES.getRegiao();

			case "4":
				result.setDestinoRegiao(NumeroGeograficos.ZERO_QUATRO.getRegiao());
				return NumeroGeograficos.ZERO_QUATRO.getRegiao();

			case "5":
				result.setDestinoRegiao(NumeroGeograficos.ZERO_CINCO.getRegiao());
				return NumeroGeograficos.ZERO_CINCO.getRegiao();
			}
		}
		return null;
	}

}
