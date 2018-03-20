package br.usjt.arqsw.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.arqsw.dao.LoginDAO;
import br.usjt.arqsw.entity.Login;

/**
 * 
 * @author Leandro Pinheiro de Holanda 816113762
 *
 */

@Service
public class LoginService {

	LoginDAO dao;
	
	@Autowired
	public LoginService(LoginDAO dao){
		this.dao = dao;
	}
	
	public boolean verificaLogin(Login login) throws IOException{
		return dao.verificaLogin(login);
	}
}
