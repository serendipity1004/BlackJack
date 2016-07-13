import java.util.Scanner;

public class Run {

	public static void main(String[] args) {

		Players player = new Players();
		Players house = new Players();
		boolean keepPlaying = true;
		boolean bust = false;
		int playerScore;
		int houseScore;

		play: while (keepPlaying) {
			boolean keepDealing = false;
			boolean correctValue = false;

			player.removeAllCards();
			house.removeAllCards();

			String dealingPhrase = "Dealing...\n";

			System.out.println(dealingPhrase);

			// deal two cards to both player and house
			for (int i = 0; i < 2; i++) {
				player.drawACard();
				house.drawACard();
			}

			// show score for player
			player.showHand();
			playerScore = player.calculateHandScore();
			System.out.println("Your Score is : " + playerScore);

			// ask if the player wants to stand or draw
			System.out.println("Press 1 for Draw or 2 for Stand");

			Scanner in = new Scanner(System.in);
			int enteredValue = in.nextInt();

			if (enteredValue == 1) {
				keepDealing = true;
			}

			// loop until 1 (Draw) 2 (Stand) is entered
			while (enteredValue != 1 && enteredValue != 2) {
				System.out.println("Enter a correct value");
				in = new Scanner(System.in);
				if (enteredValue == 1 || enteredValue == 2) {
					keepDealing = true;
					break;
				}
			}

			// Dealing until the player wants to stand
			dealing: while (keepDealing) {

				player.drawACard();
				player.showHand();
				playerScore = player.calculateHandScore();
				System.out.println("Your Score is : " + playerScore);

				if (playerScore > 21) {

					System.out.println("You are Bust!!");
					bust = true;
					break dealing;
				}

				System.out.println("Press 1 for Draw or 2 for Stand");
				in = new Scanner(System.in);
				int dealOrNot = in.nextInt();

				// enter loop if correct value is not entered.
				if (dealOrNot == 1) {
					keepDealing = true;
					continue;
				} else if (dealOrNot == 2) {
					keepDealing = false;
					break dealing;
				} else
					correctValue = true;

				// loop until correct value is entered
				while (correctValue) {

					System.out.println("Enter a correct value...");
					in = new Scanner(System.in);
					int input = in.nextInt();
					in.close();

					if (input == 1) {
						keepDealing = true;
						break;
					} else if (input == 2) {
						keepDealing = false;
						break;
					}

				}
			}

			if (bust == false) {
				// Compare score with house
				playerScore = player.calculateHandScore();
				houseScore = house.calculateHandScore();
				System.out.println("Your Score is : " + playerScore);
				System.out.println("House Score is : " + houseScore);

				if (playerScore > houseScore) {
					System.out.println("You have WON!");
				} else if (playerScore < houseScore) {
					System.out.println("You have lost...");
				} else
					System.out.println("Draw...");
			}
			

			// Ask if the player wants to keep on playing
			System.out.println("Press 1 to keep playing and press 2 to stop");

			in = new Scanner(System.in);
			int input = in.nextInt();
			in.close();

			if (input == 1) {
				keepPlaying = true;
			} else if (input == 2) {
				keepPlaying = false;
				System.out.println("Game has ended");
				break play;
			}

		}

	}
}
