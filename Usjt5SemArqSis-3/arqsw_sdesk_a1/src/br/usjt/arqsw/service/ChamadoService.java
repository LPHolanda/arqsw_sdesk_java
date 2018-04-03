package br.usjt.arqsw.service;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.arqsw.dao.ChamadoDAO;
import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;

/**
 * 
 * @author Leandro Holanda 816113762
 *
 */
@Service
public class ChamadoService {

	@Autowired
	private ChamadoDAO dao;

	public int novoChamado(Chamado chamado) throws IOException {
		return dao.novoChamado(chamado);
	}

	public ArrayList<Chamado> listarChamados(Fila Fila) throws IOException {
		return dao.listarChamados(Fila);
	}
}
