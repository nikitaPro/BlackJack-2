package blackjack;

import java.util.HashMap;

public class Room {
	private HashMap<Integer,Player> players;
	private Dealer dealer ;
	private int maxBet;
	private int maxPlayer;
	
	public int getMaxBet() {
		return maxBet;
	}
	public int getMaxPlayer() {
		return maxPlayer;
	}
	public Room(int maxBet, int maxPlayer,int decks) {
		this.players = new HashMap<Integer, Player>(maxPlayer);
		dealer = new Dealer(new CardDeck(decks));
	}
	//public void enterTheRoom(Player player){
		//players.put(player.getId(), player);
	// тут лучше сделать компил€цию интерфейсов или еще один класс с этими интерфейсом
/*	public void toDoComand(int idPlayer, String command){
		Player player = players.get(new Integer(idPlayer));
		switch (command.hashCode()) {
		case "makeBet".hashCode():
			
			break;

		default:
			break;
		}
	}*/
}
