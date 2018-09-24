package br.usjt.projeto.service;

import org.springframework.stereotype.Service;

import br.usjt.projeto.dto.FitaDTO;
import br.usjt.projeto.dto.ResultadoFormDTO;
import br.usjt.projeto.entity.MaquinaTuring;

@Service
public class FitaService {

	public ResultadoFormDTO verificaFita(FitaDTO fita) {

		ResultadoFormDTO result = new ResultadoFormDTO();
		MaquinaTuring.getInstance().lerFita(result, fita.getCelulas(), fita.getIndice());
		
		return  result;
	}
}
