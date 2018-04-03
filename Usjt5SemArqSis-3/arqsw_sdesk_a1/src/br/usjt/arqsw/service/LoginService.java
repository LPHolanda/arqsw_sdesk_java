package br.usjt.arqsw.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.arqsw.dao.LoginDAO;
import br.usjt.arqsw.entity.Login;

/**
 * 
 * @author Leandro Holanda 816113762
 *
 */
@Service
public class LoginService {

	@Autowired
	private LoginDAO loginRepository;

	public boolean buscarLogin(Login login) throws IOException {
		return loginRepository.buscarLogin(login);
	}

}
