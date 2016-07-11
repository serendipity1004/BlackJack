import java.util.Collections;
import java.util.LinkedList;

public class Deck {

	private LinkedList<Cards> listOfCards = new LinkedList<Cards>();
	
	public Deck() {

	}
	
	public void createDeck() {
		for (int i = 0; i < 4; i++){
			for (int j = 0; j < 13; j++){
				listOfCards.add(new Cards(i, j));
			}
		}
	}
	
	public void showAllDeck(){
		if (listOfCards.size()==0){
			createDeck();
			shuffleDeck();
		}
		for (Cards arbCards : listOfCards){
			System.out.println(arbCards);
		}
	}
	
	public void shuffleDeck(){
		Collections.shuffle(listOfCards);
	}
	
	public Cards drawFromDeck(){
		if (listOfCards.size()==0){
			createDeck();
			shuffleDeck();
		}
		
		return listOfCards.removeFirst();
	}
	
}