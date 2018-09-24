package br.usjt.projeto.controller;

import static br.usjt.projeto.enumerator.Direcao.DIREITA;
import static br.usjt.projeto.enumerator.Direcao.ESQUERDA;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.usjt.projeto.dto.CelulaDTO;
import br.usjt.projeto.dto.FitaDTO;
import br.usjt.projeto.dto.ResultadoFormDTO;
import br.usjt.projeto.service.FitaService;

@Controller
@Transactional
public class FitaController {

	@Autowired
	private FitaService fitaService;

	@Transactional
	@RequestMapping("/call")
	public String verificaFita(@RequestParam String number, ResultadoFormDTO form, Model model) {
		try {
			List<CelulaDTO> celula = new ArrayList<>();
			
			String a = number;
			
			int[] array = new int[100];
			int i;
			
			for (i = 0; i < a.length(); i++) {
				array[i] = a.charAt(i) - 48;
				celula.add(new CelulaDTO(i, Integer.toString(array[i]), DIREITA));
			}
			celula.add(new CelulaDTO(i, "", ESQUERDA));

			FitaDTO fita = new FitaDTO();
			fita.setCelulas(celula);
			fita.setIndice(0);
			
			form = fitaService.verificaFita(fita);
			model.addAttribute("chamada", form);
			return "ChamadaRecebida";
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro";
		}
	}

}