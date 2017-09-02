package blackjack;

public class Card {
	public final static char[] SUIT = {'D','H','S','C'};
	private int rank;
	private char suit;
	public Card(int rank, char suit) {
		if(suit!=SUIT[1]||suit!=SUIT[2]||suit!=SUIT[3]||suit!=SUIT[4])
			throw new IllegalArgumentException("Wrong suit");
		this.rank = rank;
		this.suit = suit;
	}
	public int getRank() {
		return rank;
	}
	public char getSuit() {
		return suit;
	}
	
}
