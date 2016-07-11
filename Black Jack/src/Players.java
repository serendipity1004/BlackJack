import java.util.LinkedList;

public class Players {

	private LinkedList<Cards> cardsInHand = new LinkedList<>();
	private Deck deck = new Deck();
	private int numbAces;
	
	public Players() {
		
	}
	
	public void removeAllCards(){
		cardsInHand.clear();
	}
	
	public void drawACard(){
		Cards drawnCard = deck.drawFromDeck();
		
		if (cardsInHand.size() == 0){
			numbAces = 0;
		}
		
		if (drawnCard.getNumb() == 11){
			numbAces++;
		}
		
		cardsInHand.add(drawnCard);
		System.out.println("Card Drawn is : " + drawnCard);
	}
	
	public void showHand(){
		for (Cards arbCards : cardsInHand){
			System.out.println(arbCards);
		}
	}
	
	public int calculateHandScore(){
		int handScore = 0;
		
		for (Cards arbCards : cardsInHand){			
			handScore += arbCards.getNumb();
		}
		
		while (numbAces > 0 && handScore > 21){
			handScore -= 10;
			numbAces--;
		}
		
		System.out.println("Your score is : " + handScore);
		
		return handScore;
	}
	
}