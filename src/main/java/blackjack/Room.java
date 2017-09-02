package blackjack;

import java.util.HashMap;

public class Room {
	private HashMap<Integer,Player> players;
	private Dealer dealer ;
	private int maxBet;
	private int maxPlayer;

	public Room(int maxBet, int maxPlayer,int decks) {
		this.players = new HashMap<Integer, Player>(maxPlayer);
		dealer = new Dealer(new CardDeck(decks));
	}
	public void enterTheRoom(Player player){
		players.put(player.getId(), player);
	}
	
}
