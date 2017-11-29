package blackjack;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dataBases.DataBase;

public class Player {
	private int id = 0;
	private int account =0;
	private int bet = 0;
	private int insuranceBet = 0;
	private ArrayList<Card> cards;
	
	public Player(DataBase db, String login,String pass) throws SQLException{
		signIn(db, login, pass);
		cards = new ArrayList<Card>();
	}
	
	private void signIn(DataBase db,String login,String pass) throws SQLException {
		check(login, pass);
		int passHash = pass.hashCode();
		String query = "SELECT id, account FROM player WHERE login='"
				+ login
				+ "' and "
				+ "password="+passHash
				+ ");";
		ResultSet rs = db.getResult(query);
		if(rs.next()){
			id=rs.getInt(1);
			account=rs.getInt(2);
		}
		else
			throw new SecurityException("Wrong pass or login");
	}
	private static void check(String login, String pass){
		if(pass.indexOf("'")!=-1||login.indexOf("'")!=-1)
			throw new SecurityException("Login or Password mustn't contain '");
		if(login.isEmpty()||pass.isEmpty())
			throw new SecurityException("Login or Password mustn't be empty");
	}
	public static void signUp(DataBase db, String login, String pass) throws SQLException {
		check(login, pass);
		String query = "SELECT id FROM player WHERE login='"
				+ login
				+ "');";
		ResultSet rs = db.getResult(query);
		if(rs.next())
			throw new SecurityException("User with same name already exist.");
		int passHash = pass.hashCode();
		String signUpQuery = "INSERT INTO player VALUES (DEFAULT,0,'"
		+login+"',"
		+ passHash+");";
		db.executeUpdate(signUpQuery);
	}
	public int getAccount() {
		return account;
	}
	public void won() {
		this.account+=bet;
		bet=0;
		this.account-=insuranceBet;
		insuranceBet=0;
		cards.clear();
	}
	public void lose(boolean blackjack) {
		this.account-=bet;
		bet=0;
		if(blackjack)
			this.account+=insuranceBet*2;
		else
			this.account-=insuranceBet;
		cards.clear();
	}
	public void saveAccount(DataBase db) throws SQLException{
		int res = db.executeUpdate("UPDATE player SET account ="+account+" WHERE id = "+id);
		if(res==0)throw new SQLException("Something went wrong");
	}
	public int getBet() {
		return bet;
	}
	public void setBet(int bet, int max) throws Exception {
		if(bet>account)
			throw new Exception("Not enough money");
		if(bet>max)
			throw new Exception("Too big bet");
		if(bet!=0)
			throw new Exception("Bet already done");
		this.bet = bet;
	}
	public int getId() {
		return id;
	}
	public void putCard(Card card){
		cards.add(card);
	}
	public String[] getCards(){
		return (String[])cards.toArray();
	}
	public void makeInsuranceBet(){
		insuranceBet=bet/2;
	}
}
