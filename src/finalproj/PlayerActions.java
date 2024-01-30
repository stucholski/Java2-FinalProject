package finalproj;

import java.util.Scanner;

public class PlayerActions {
	
	public void reviewActions() {
		Scanner in = new Scanner(System.in);
		
		Room room = new Room();
		Help help = new Help();
		PickUp pickup = new PickUp();
		
		String a = in.nextLine();
		
		switch (a.trim()) {
		case "move to room":
			room.enterRoom();
			break;
		case "view inventory":
			room.enterRoom();
			break;
		case "chop vegetables":
			room.enterRoom();
			break;
		case "pick up noodles":
			pickup.pickUpText();
		case "help":
			help.helpText();
			
		default :
			System.out.println("You shouldn't do that right now. Try another action or ask for help.");
			this.reviewActions();
		break;
		}
		
	
	}

}
