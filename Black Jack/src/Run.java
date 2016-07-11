import java.util.Scanner;

public class Run {

	public static void main(String[] args) {

		Players player = new Players();
		Players house = new Players();
		boolean keepPlaying = true;

		while (keepPlaying) {
			boolean keepDealing = true;

			player.removeAllCards();
			house.removeAllCards();

			String dealingPhrase = "Dealing...";

			System.out.println(dealingPhrase);

			// deal two cards to both player and house
			for (int i = 0; i < 2; i++) {
				player.drawACard();
				house.drawACard();
			}

			// show score for player
			player.showHand();

			// ask if the player wants to stand or draw
			System.out.println("Press 1 for Draw or 2 for Stand");

			Scanner in = new Scanner(System.in);

			while (in.nextInt() != 1 && in.nextInt() != 2) {
				System.out.println("Enter a correct value");
				in = new Scanner(System.in);
				if (in.nextInt() == 1 || in.nextInt() == 2) {
					keepDealing = true;
					break;
				}
			}

			dealing: while (keepDealing) {
				keepDealing = false;

				player.drawACard();
				player.showHand();
				player.calculateHandScore();

				if (player.calculateHandScore() > 21) {

					System.out.println("You are Bust!!");

					break dealing;
				}

				System.out.println("Press 1 for Draw or 2 for Stand");
				in = new Scanner(System.in);

				boolean correctValue = true;

				while (correctValue) {
					correctValue = false;

					if (in.nextInt() == 1) {
						keepDealing = true;
						break;
					} else if (in.nextInt() == 2) {
						keepDealing = false;
						break;
					} else
						while (in.nextInt() != 1 && in.nextInt() != 2) {
							System.out.println("Enter a correct value");
							in = new Scanner(System.in);
							if (in.nextInt() == 1 || in.nextInt() == 2) {
								keepDealing = true;
								correctValue = true;
								break;
							}
						}
				}
			}

			System.out.println("Press 1 to keep playing and press 2 to stop");

			Scanner playOrNot = new Scanner(System.in);

			if (playOrNot.nextInt() == 1) {
				keepPlaying = true;
			} else if (playOrNot.nextInt() == 2) {
				keepPlaying = false;
			}

		}
		System.out.println("Game has ended");

	}
}