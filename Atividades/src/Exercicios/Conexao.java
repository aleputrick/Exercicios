package Exercicios;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao{
	
	public static void main(String[] args) {
		new Conexao().testarConexao();
	}

	public static Connection testarConexao() {
		Connection c = conectarPostGree();
		if (c != null) {
			System.out.println("Conectado com sucesso.");
		} else {
			System.out.println("problemas na conexão.");
		}
		return c;

	}

	public static Connection conectarPostGree() {
		try {
			
			Class.forName("org.postgresql.Driver");

			String url = "jdbc:postgresql://localhost:4321/clientes";
			Connection con = DriverManager.getConnection(url, "postgres", "1234");
			return con;
		} catch (ClassNotFoundException e) {
			Conexao.printSQLException(null, e);
		} catch (SQLException e) {
			Conexao.printSQLException(e, null);
		}
		return null;
	}

	public static void printSQLException(SQLException ex, Exception exception) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				if (((SQLException) e).getSQLState().equalsIgnoreCase("42P01")) {
					System.err.println("Tabela não existe: ");
					break;
				} else {
					System.err.println("SQLState: " + ((SQLException) e).getSQLState());
					System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
					System.err.println("Message: " + e.getMessage());
					Throwable t = ex.getCause();
					while (t != null) {
						System.out.println("Cause: " + t);
						t = t.getCause();
					}
				}
			}
		}
		if (exception != null) {
			exception.toString();
			System.out.println("\n");
			exception.printStackTrace();
		}
	}
}
