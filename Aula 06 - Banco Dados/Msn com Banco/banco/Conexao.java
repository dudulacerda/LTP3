package banco;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Conexao {
	
	private static Connection conn;
	
	public Conexao() {
	
		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			
			String url = "jdbc:mysql://127.0.0.1:3306";
			
			String user = "root";
			String password = "";
			
			conn = (Connection) DriverManager.getConnection(url, user, password);
			conn.setAutoCommit(false);
			conn.setCatalog("mensageiro");
							
		} catch (Exception e){
			System.err.println(e);
			System.out.println("erro");
			System.exit(-1);	
		}

	}
	
	public void gravaHistorico(String de, String para, String texto){
		String query = "INSERT INTO mensagem (de, para, texto) values ('"+de+"','"+para+"','"+texto+"')";
		
		Statement stmt;
		
		try {
			stmt = (Statement) conn.createStatement();
			stmt.executeUpdate(query);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public void imprimiHistorico(){
		
		String query1 = "SELECT * FROM mensagem";
		
		Statement stmt1;
		try {
			stmt1 = (Statement) conn.createStatement();
			ResultSet rs = stmt1.executeQuery(query1);
			
			while (rs.next()){
				System.out.print(rs.getString("de")+" ");
				System.out.print(rs.getString("para")+", ");
				System.out.println(rs.getString("texto"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
