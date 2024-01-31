package finalproj;

import java.util.Scanner;

public class Player1 {

	String name = "Chef";

	Room room;

	PlayerActions action;

	Inventory inventory;

	Item itemInHand;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	
		Room room = new Room();
		PlayerActions actions = new PlayerActions();
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome to the text-based adventure game. You are a chef at an Italian restaurant. A customer ordered a plate of spaghetti. ");
		System.out.println("The ingredients for this dish are noodles, sauce, and meat. You are in the kitchen, and you may enter the pantry, dining room, or freezer. ");
		System.out.println("What do you do?");
		actions.reviewActions();
		
		

}
}
