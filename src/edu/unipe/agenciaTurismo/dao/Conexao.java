package edu.unipe.agenciaTurismo.dao;
import java.sql.*;

public class Conexao {
	
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost/agencia";
	private static final String USER = "root";
	private static final String PASS = "leolira";
	
	public static Connection open() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void close(Connection conn,
                             PreparedStatement pstm, ResultSet rs)
    {
        try {
            if (conn != null) {
                conn.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (rs != null) {
               rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
}
