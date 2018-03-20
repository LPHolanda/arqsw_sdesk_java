package br.usjt.arqsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import br.usjt.arqsw.entity.Login;

/**
 * 
 * @author Leandro Pinheiro de Holanda 816113762
 *
 */

@Repository
public class LoginDAO {
	
	private Connection conn;
	
	/*@Autowired
	public LoginDAO(DataSource dataSource) throws IOException {
		try {
			this.conn = dataSource.getConnection();
		} catch (SQLException e) {
			throw new IOException(e);
		}
	}*/

	public boolean verificaLogin(Login login){

		String sqlVerifica = "select * from usuario where username=? and password=?";
		Boolean status = false;

		try (PreparedStatement pst = conn.prepareStatement(sqlVerifica);){
			pst.setString(1, login.getUsername());
			pst.setString(2, login.getPassword());
			ResultSet rs = pst.executeQuery();

			if(rs.next()){
				status = true;
			}
		} catch (SQLException erroSql) {
			throw new RuntimeException(erroSql);
		}
		return status;
	}
}
