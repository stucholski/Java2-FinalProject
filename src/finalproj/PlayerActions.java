package finalproj;

import java.util.Scanner;

public class PlayerActions {

	public void reviewActions() {
		Scanner in = new Scanner(System.in);
		boolean continuePlaying = true; //Added, If it is true, the game will keep running
		//If it is changed to false the game will stop running

		//Room room = new Room();
		Help help = new Help();
		PickUp pickup = new PickUp();

		//Using while loop so the game always prompts the user for actions unless the game has ended
		//Or the game is quit
		while (continuePlaying) {
			System.out.println("What do you want to do?");
			String action = in.nextLine().trim();

			switch (action) {
				case "move to room":
					//room.enterRoom();
					break;
				case "view inventory":
					//Implement viewInventory method
					System.out.println("Viewing inventory");
					break;
				case "chop vegetables":
					//Implement chopVegetables method
					System.out.println("Chopping vegetables");
					break;
				case "pick up noodles":
					pickup.pickUpText();
					break;
				case "help":
					help.helpText();
					break; //Ensure execution stops here for the help case
				case "quit":
					continuePlaying = false; //Exit the loop and end the game
					System.out.println("Quitting game...");
					break;
				default:
					System.out.println("You shouldn't do that right now. Try another action or ask for help.");
					break;
			}
		}

		in.close(); //Close Scanner
	}

}

