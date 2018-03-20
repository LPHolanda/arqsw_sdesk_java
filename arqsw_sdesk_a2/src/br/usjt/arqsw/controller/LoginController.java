package br.usjt.arqsw.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import br.usjt.arqsw.entity.Login;
import br.usjt.arqsw.service.LoginService;

/**
 * 
 * @author Leandro Pinheiro de Holanda 816113762
 *
 */

public class LoginController {

	private LoginService loginService;

	@Autowired
	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}
	
	@RequestMapping("FormularioLogin")
	public String telaLogin() {
		return "FormularioLogin";
	}
	
	@RequestMapping("/efetuarLogin")
	public String efetuarLogin(Login login, HttpSession session) throws IOException {
		if(loginService.verificaLogin(login) == true) {
			session.setAttribute("usuarioLogado", login);
			return "index";
		}
		return "redirect:FormularioLogin";
	}
}
