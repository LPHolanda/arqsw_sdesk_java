package br.ust.projeto.test;

import static br.usjt.projeto.enumerator.Direcao.DIREITA;
import static br.usjt.projeto.enumerator.Direcao.ESQUERDA;

import java.util.ArrayList;
import java.util.List;

import br.usjt.projeto.dto.CelulaDTO;
import br.usjt.projeto.dto.ResultadoFormDTO;
import br.usjt.projeto.entity.MaquinaTuring;

public class MainTest {

	public static void main(String[] args) {

		ResultadoFormDTO result1 = new ResultadoFormDTO();
		ResultadoFormDTO result2 = new ResultadoFormDTO();
		ResultadoFormDTO result3 = new ResultadoFormDTO();

		List<CelulaDTO> fita = new ArrayList<>();
		
		//PRIMEIRA CHAMADA
		String a = "0146067521";
		System.out.println(a);
		
		int[] array = new int[100];
		int i;

		for (i = 0; i < a.length(); i++) {
			array[i] = a.charAt(i) - 48;
			fita.add(new CelulaDTO(i, Integer.toString(array[i]), DIREITA));
		}
		fita.add(new CelulaDTO(i, "", ESQUERDA));
		
		MaquinaTuring.getInstance().lerFita(result1, fita, 0);
		System.out.println(result1.toString());

		System.out.println("*---------------------------*");
		//SEGUNDA CHAMADA
		fita = new ArrayList<>();
		a = "0946067521";
		System.out.println(a);
		
		array = new int[100];
		i = 0;

		for (i = 0; i < a.length(); i++) {
			array[i] = a.charAt(i) - 48;
			fita.add(new CelulaDTO(i, Integer.toString(array[i]), DIREITA));
		}
		fita.add(new CelulaDTO(i, "", ESQUERDA));
		
		MaquinaTuring.getInstance().lerFita(result2, fita, 0);
		System.out.println(result2.toString());
		System.out.println("*---------------------------*");
		
		//TERCEIRA CHAMADA
		fita = new ArrayList<>();
		a = "005533144111030";
		System.out.println(a);
		
		array = new int[100];
		i = 0;

		for (i = 0; i < a.length(); i++) {
			array[i] = a.charAt(i) - 48;
			fita.add(new CelulaDTO(i, Integer.toString(array[i]), DIREITA));
		}
		fita.add(new CelulaDTO(i, "", ESQUERDA));
		
		MaquinaTuring.getInstance().lerFita(result3, fita, 0);
		System.out.println(result3.toString());
	}
}