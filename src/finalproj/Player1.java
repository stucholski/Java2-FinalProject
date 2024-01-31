package finalproj;

import java.util.Scanner;

public class Player1 {

	//Begins the game and calls the class to review player input
	public static void main(String[] args) {
	
		try{
		PlayerActions actions = new PlayerActions();
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome to the text-based adventure game. You are a chef at an Italian restaurant. A customer ordered a plate of spaghetti. ");
		System.out.println("The ingredients for this dish are noodles, sauce, and meat. You are in the kitchen, and you may enter the pantry, dining room, or freezer. ");
		System.out.println("What do you do?");
		actions.reviewActions();
		}catch (Exception ex){
			System.err.println(ex.toString());
		}



		

}
}
