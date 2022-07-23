import java.util.Scanner;
import java.util.Random;

public class Memory extends CardGame  {
	private Card firstCard;
	private Card secondCard;
	private Card[][] memoryDeck;
	private int guesses;

	public static final int MAX_GUESSES = 52;
	
	public Memory(){
		guesses = 0;
		memoryDeck = new Card[4][13];
		int row = 0;
		int col = 0;
		
		while(row < 4){
			col = 0;
			while( col < 13 ){
				Random r = new Random();
				int card = r.nextInt(52);
				if(!deck[card].faceUp){
					memoryDeck[row][col] = new Card(deck[card]);
					deck[card].flip();
					col++;
				}	
			}
			row++;
		}
	}

	public void play() {
		Scanner in = new Scanner(System.in);

		int first;
		int second;
		int third;
		int fourth;

		while( guesses < MAX_GUESSES) {
			printGame();
			System.out.print("Enter the row and column of the card: ");
			first = in.nextInt();
			second = in.nextInt();

			
			firstCard = memoryDeck[first][second];
			if( first < 4 && second < 13 && !memoryDeck[first][second].isFlipped()) {
				System.out.println(firstCard.toString());
			}

			else {
				System.out.println("Invalid numbers.");
				break;
			}
	
			
			System.out.print("Enter the row and column of the card: ");
			third = in.nextInt();
			fourth = in.nextInt();

			secondCard = memoryDeck[third][fourth];
			
			if( third < 4 && fourth < 13 && !memoryDeck[third][fourth].isFlipped()) {
				System.out.println(secondCard.toString());

			}

			else {
				System.out.println("Invalid numbers.");
				break;
			}


			if (isMatch()) {
				System.out.println("Match found.");
		
			}
			else {
				System.out.println("No match.");
				guesses++;
			}
		}
	}

	public boolean win() {
		
		boolean win = true;
	
		for (Card[] card1: memoryDeck) {
			for(Card card2: card1){
	
				if(!card2.isFlipped())
				win = false;
			}
		}
		return win;
		}

	public void printGame(){
		for( int r = 0; r < 4; r++ ){
			for(int c = 0; c < 13; c++){
				if( !memoryDeck[r][c].isFlipped()){
					System.out.printf("%8s","******");
				}
				else {
					System.out.printf( "%8s",memoryDeck[r][c]);
				}
				
			}
			System.out.println();
		}
	}
	public boolean isMatch() {
		if(firstCard.getValue() == secondCard.getValue()) {
				firstCard.flip();
				secondCard.flip();
				return true;
		}
		return false;
	}

	
		
}