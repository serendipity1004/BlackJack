
public class Cards {
	
	private int numb;
	private int suite;
	
	public Cards(int suite, int numb) {
		this.numb = numb;
		this.suite = suite;
	}
	
	public int getNumb() {
		
		if (numb == 0){
			return 11;
		}
		
		if (numb >= 9 && numb <=12){
			return 10;
		}
		
		return numb + 1;
	}
	
	@Override
	public String toString() {
		
		String arbNumb = null;
		String arbSuite = null;
		
		switch (suite){
			
		case 0:
			arbSuite = "Heart";
			break;
		
		case 1:
			arbSuite = "Diamond";
			break;
		
		case 2:
			arbSuite = "Spades";
			break;
		
		case 3:
			arbSuite = "Clubs";
			break;
		
		}
		
		switch (numb){
		
		case 0:
			arbNumb = "Ace";
			break;
			
		case 10:
			arbNumb = "Jack";
			break;
		
		case 11:
			arbNumb = "Queen";
			break;
			
		case 12:
			arbNumb = "King";
			break;
			
		}
		
		if (numb > 0 && numb < 10){
			arbNumb = String.valueOf(numb+1);
		}
		
		return arbNumb + " of " + arbSuite;
	}

}
