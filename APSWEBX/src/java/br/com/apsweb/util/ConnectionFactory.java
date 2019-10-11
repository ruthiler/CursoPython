package br.com.apsweb.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/agendamentoWeb";
    private static final String USER = "admin";
    private static final String PASS = "123456";

    public static Connection getConnection() {
        try{
		Class.forName(DRIVER);
		return DriverManager.getConnection(URL, USER, PASS);
	} catch  (ClassNotFoundException | SQLException ex) {
		throw new RuntimeException("Erro na conexão", ex);
        }
    }
}
