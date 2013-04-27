/* JDBC - Java database connectivity
 * 
 * API para envio de instruções SQL para qualquer banco relacional, API em baixo nível
 * utiliza Drivers para se comunicar com cada banco.
 */

package exemplo;

import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


public class Jdbc {

	public static void main(String[] args) {
		Connection conn;
		
		try{
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			
			String url = "jdbc:mysql://127.0.0.1:3306";
			
			String user = "root";
			String password = "";
			
			String nome = "Etelma";
			String sobre = "Lacerda";
			int idade = 52;
			
			conn = (Connection) DriverManager.getConnection(url, user, password);
			
			conn.setAutoCommit(false);
			conn.setCatalog("jdbc");   //Diz qual a database que o banco vai utilizar
				
			String query = "INSERT INTO pessoa (nome, sobrenome, idade) values ('"+nome+"','"+sobre+"',"+idade+")";
			
			Statement stmt = (Statement) conn.createStatement();
			
			int num = stmt.executeUpdate(query);
			
			conn.commit();
			
			System.out.println("Inseridos "+ num +" itens");
			
			String query1 = "SELECT * FROM pessoa";
			
			Statement stmt1 = (Statement) conn.createStatement();
			
			ResultSet rs = stmt1.executeQuery(query1);
			
			while (rs.next()){
				System.out.print(rs.getString("nome")+" ");
				System.out.print(rs.getString("sobrenome")+", ");
				System.out.println(rs.getInt("idade"));
			}
				
		} catch (Exception e){
			System.err.println(e);
			System.exit(-1);
		}
	}

}

