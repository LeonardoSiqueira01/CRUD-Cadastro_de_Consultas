package conexaoJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoBanco {
	private static String UrlBanco = "jdbc:mysql://localhost:3306/CRUD?useTimezone=true&serverTimezone=UTC&useSSL=false";
	private static String User = "developer";
	private static String Password = "1234567";
	private static Connection conn = null;

	static {
		conectar();

	}

	public ConexaoBanco() {
		conectar();
	}

	private static void conectar() {
		try {
			if (conn == null) {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(UrlBanco, User, Password);
				conn.setAutoCommit(false);
				System.out.println("Conectou com Sucesso!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection fazerConexao() {
		return conn;
	}

	public static void fecharResultSet(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void fecharStatment(Statement st) {
		try {
			if (st != null) {
				st.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
