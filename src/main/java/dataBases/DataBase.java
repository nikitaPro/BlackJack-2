package dataBases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * @author Nikita Prokopenko
 */
public class DataBase {
	public String url=null; 
	private String user=null; 	
	private String pass=null;
	private Connection conn = null; // куда подсоединяемся
	private Statement st = null;
	public DataBase (String url, String user, String pass){
		this.url=url;
		this.user=user;
		this.pass=pass;
	}
	/**
	 * @return Integer if success return 1 else null
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * */
	public void init() throws SQLException, ClassNotFoundException{
		System.out.println("--PostgreSQL JDBC Connection Testing --");
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Include PostgreSQL JDBC Driver in your library path!");
			e.printStackTrace();
			throw new ClassNotFoundException();
		}
		System.out.println("PostgreSQL JDBC Driver Registered!");
		conn = DriverManager.getConnection("jdbc:postgresql://"+url, user, pass);
		st = conn.createStatement();
	}
	public ResultSet getResult (String query) throws SQLException{
		newCreateStatment();
		ResultSet rs;
		rs = st.executeQuery(query);
		return rs;
	}
	public int executeUpdate(String query) throws SQLException{
		newCreateStatment();
		return st.executeUpdate(query);
	}
	private void newCreateStatment() throws SQLException{
			st = conn.createStatement();
	}
}
