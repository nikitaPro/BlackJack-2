package blackjack;

import java.util.ArrayList;

public class Dealer  {
	private CardDeck deck = null;
	private ArrayList<Card> cards;
	private boolean insurance;

	public Dealer(CardDeck deck) {
		this.deck = deck;
		cards = new ArrayList<Card>(5);
		insurance = false;
	}
	public synchronized void hit(Player pl){
		pl.putCard(deck.getCard());
	}
	public void takeBet(Player pl, int bet, int max)throws Exception{
		pl.setBet(bet, max);
	}
	public void toDealForDealer(){
		Card card=deck.getCard();
		cards.add(card);
		if(card.getRank()==14)
			insurance=true;
		cards.add(deck.getCard());
	}
	public void DealersHits(){
		int hittingPoint = 16;
		int score=getScore(cards);
		while(score<hittingPoint){
			cards.add(deck.getCard());
			score=getScore(cards);
		}
	}
	public int getScore(ArrayList<Card> cards){
		int score=0;
		int haveAce=0;
		int rank;
		for (Card card : cards) {
			rank=card.getRank();
			if(rank>10)
				score+=10;
			else
				score+=rank;
			if(rank==14)haveAce++;
		}
		for (int i = 0; i < haveAce; i++) {
			if(score<=10)
				score+=11;
			else
				score+=1;
		}
		return score;
	}
}
