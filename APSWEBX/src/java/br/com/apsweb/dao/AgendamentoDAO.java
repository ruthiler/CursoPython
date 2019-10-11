package br.com.apsweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.apsweb.bean.Agendamento;
import br.com.apsweb.util.ConnectionFactory;

public class AgendamentoDAO {

	Connection connection;
	
	public AgendamentoDAO() {
		connection = ConnectionFactory.getConnection();
	}
	
	public boolean inserir(Agendamento agendamento) {
		
		try {
			String SQL = "insert into agendamento (nome, telefone, veiculo, data, hora) values"
					+"(?, ?, ?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setString(1, agendamento.getNome());
			ps.setString(2, agendamento.getTelefone());
			ps.setString(3, agendamento.getVeiculo());
			ps.setString(4, agendamento.getData());
			ps.setString(5, agendamento.getHora());
			
			ps.executeUpdate();
			ps.close();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Falha ao adcionar agendamento no BD");
		}
	}
	
	public List<Agendamento> listar(){
		
                List<Agendamento> agendamentos = new ArrayList<Agendamento>();
		try {
			String SQL = "select * from agendamento";
                        ResultSet rs;
                    try (PreparedStatement ps = connection.prepareStatement(SQL)) {
                        rs = ps.executeQuery();
                        while (rs.next()) {
                            Agendamento agendamento = new Agendamento();
                            agendamento.setCod(rs.getInt("cod"));
                            agendamento.setNome(rs.getString("nome"));
                            agendamento.setTelefone(rs.getString("telefone"));
                            agendamento.setVeiculo(rs.getString("veiculo"));
                            agendamento.setData(rs.getString("data"));
                            agendamento.setHora(rs.getString("hora"));
                            agendamento.setStatus(rs.getInt("status"));
                            agendamentos.add(agendamento);
                            
                        }
                    }
			rs.close();
			return agendamentos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Falha ao lista agendamentos no BD");
		}
   }
	
	
        public boolean remover(int cod) {
		try {
			
			String SQL = "delete from agendamento WHERE cod = ?";
			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setInt(1, cod);
						
			ps.executeUpdate();
			ps.close();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Falha ao remover agendamento no BD");
		}
	}
	
	public boolean concluir(int cod) {
		try {
			String SQL = "UPDATE agendamento SET status='1' WHERE cod = ?";
                    try (PreparedStatement ps = connection.prepareStatement(SQL)) {
                        ps.setInt(1, cod);
                        ps.executeUpdate();
                    }
			
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Falha ao remover agendamento no BD");
		}
	}
	
	public List<Agendamento> buscarNome(String nomeBusca) {
		List<Agendamento> agendamentos = new ArrayList<Agendamento>();
		try {
			String SQL = "select * from agendamento WHERE nome like %?%";
			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setString(1, nomeBusca);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Agendamento agendamento = new Agendamento();
				agendamento.setCod(rs.getInt("cod"));
				agendamento.setNome(rs.getString("nome"));
				agendamento.setTelefone(rs.getString("telefone"));
				agendamento.setVeiculo(rs.getString("veiculo"));
				agendamento.setData(rs.getString("data"));
				agendamento.setHora(rs.getString("hora"));
				agendamento.setStatus(rs.getInt("status"));
				agendamentos.add(agendamento);
			}
			ps.close();
			rs.close();
			return agendamentos;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Falha ao buscar agendamento no BD");
		}
	}
		
	public boolean alterar(Agendamento agendamento) {
		try {
			String SQL = "UPDATE agendamento SET nome=?,telefone=?,veiculo=?,"+
						"data=?,hora=? WHERE cod = ?";
			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setString(1, agendamento.getNome());
			ps.setString(2, agendamento.getTelefone());
			ps.setString(3, agendamento.getVeiculo());
			ps.setString(4, agendamento.getData());
			ps.setString(5, agendamento.getHora());
			ps.setInt(6, agendamento.getCod());
			ps.executeUpdate();
			ps.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Falha ao remover agendamento no BD");
		}
	}
	
}