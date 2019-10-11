package br.com.apsweb.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.apsweb.bean.Usuario;
import br.com.apsweb.util.ConnectionFactory;

public class UsuarioDAO {

	Connection connection;
	
	public UsuarioDAO() {
		connection = ConnectionFactory.getConnection();
	}
	
	public void inserir(Usuario usuario) {
		
		try {
			String SQL = "insert into usuarios (username, senha, nivel) values (?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setString(1, usuario.getUsername());
			ps.setString(2, usuario.getSenha());
			ps.setInt(3, usuario.getNivel());
						
			ps.executeUpdate();
			ps.close();
			
			System.out.println(usuario.getUsername() + " Foi cadastrado no BD.");		
		} catch (SQLException e) {
		// TODO Auto-generated catch block
			throw new RuntimeException(">>> Falha ao adcionar usuarios no BD...");
		}
	}
	
	public List<Usuario> listar(){
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			String SQL = "select * from usuarios";
			PreparedStatement ps = connection.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setUsername(rs.getString("username"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setNivel(rs.getInt("nivel"));
				usuarios.add(usuario);
								
			}
			ps.close();
			rs.close();
			return usuarios;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(">>> Falha ao listas usuario no BD...");
		}
	}
	
	public void remover(String username) {
		try {
			String SQL = "delete from usuarios WHERE username = ?";
			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setString(1, username);
			
			ps.executeUpdate();
			ps.close();
			System.out.println(username + " Removido do BD");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(">>> Falha ao remover usuario no BD...");
		}
		
	}
	
	public Usuario login(Usuario usuario) {
		try {
			String SQL = "select * from usuarios WHERE username = ? AND senha= ?";
			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setString(1, usuario.getUsername());
			ps.setString(2, usuario.getSenha());
			ResultSet rs = ps.executeQuery();
				
			Usuario usuarioBd = new Usuario();
									
			if (rs.next()) {
				usuarioBd.setUsername(rs.getString("username"));
				usuarioBd.setSenha(rs.getString("senha"));
                                usuarioBd.setNivel(rs.getInt("nivel"));
				System.out.println(usuario.getUsername() + " Login Válidado ");
				ps.close();
				rs.close();
				return usuarioBd;
			}else {
				System.out.println(usuario.getUsername() + " Lógin invalido ");
				ps.close();
				rs.close();
			}
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(">>> Falha ao logar no BD");
		}
		return null;
	}
	
	public boolean verificaUsername(String username) {
		try {
			String SQL = "select * from usuarios WHERE username = ?";
			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				System.out.println("O usuario "+ username + " está cadastrado");
				ps.close();
				rs.close();
				return true;
			}
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(">>> Falha ao prequisarisar agendamento no BD");
		}
                return (false);
                
	}
		
	public void alterarSenha(Usuario usuario, String novaSenha) {
		try {
			String SQL = "UPDATE usuario SET senha=? WHERE username = ?";
			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setString(1, novaSenha);
			ps.setString(2, usuario.getUsername());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(">>> Falha ao remover agendamento no BD...");
		}
	}
	
	public void alterarUsuario(Usuario usuarioNovo, Usuario usuarioAnt) {
		try {
			String SQL = "UPDATE usuario SET username=?,senha=? WHERE username = ?";
			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setString(1, usuarioNovo.getUsername());
			ps.setString(2, usuarioNovo.getSenha());
			ps.setString(3, usuarioAnt.getUsername());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(">>> Falha ao remover agendamento no BD...");
		}
	}
	
}