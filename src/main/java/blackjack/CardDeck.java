/**
 * 
 */
package blackjack;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

/**
 * @author Nikita
 *
 */
public class CardDeck {
	private int deckAmount = -1;
	private Card[] deck = null;
	/**Create mixed deck
	 * @param deckAmount - amount of decks in the one. 0 - if decks amount is infinity.*/
	public CardDeck(int deckAmount){
		if(deckAmount <= -1) throw new IllegalArgumentException("Too small deck");
		this.deckAmount = deckAmount;
		createDeckStack();
		mix();
	}
	private void createDeckStack(){
		//if(this.deckAmount <= -1) throw new IllegalArgumentException("Too small deck");
		int deckAmount;
		if (this.deckAmount==0)
			deckAmount=1;
		else 
			deckAmount = this.deckAmount;
		int max=deckAmount*52;
		Card[] deck = new Card[max];
		for (int i = 0; i < deckAmount; i++) {
			for (int j = 0; j <= 4; j++) {
				for (int j2 = 2; j2 < 14; j2++) {
					deck[i+j]=new Card(j2,Card.SUIT[j]);
				}
			}
		}
		this.deck=deck;
	}
	private Random getGenerator(){
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(new Date());
		Random generator = new Random(gc.getTimeInMillis()); 
		generator.setSeed(generator.nextLong());
		return generator;
	}
	/**Mix cards in the deck*/
	private void mix(){
		if (deckAmount==0) return;
		Random generator = getGenerator();
		int index_1 = -1;
		Card cell;
		for (int i = 0; i < deck.length; i++) {
			index_1=generator.nextInt(deck.length);
			cell=deck[index_1];
			deck[index_1]=deck[i];
			deck[i]=cell;
		}
	}
	public Card[] getDeck() {
		if (deckAmount==0) throw new IllegalStateException("It is impossible to return infinity deck");
		return deck;
	}
	public Card getCard() {
		Random generator = getGenerator();
		int index;
		Card card;
		do{
			index = generator.nextInt(deck.length);
			card = deck[index];
		}while(card==null);
		if(deckAmount!=0)
			deck[index]=null;
		return card;
	}
	/**Create ordered deck and mix cards in it*/
	public void refresh(){
		createDeckStack();
		mix();
	}
}
