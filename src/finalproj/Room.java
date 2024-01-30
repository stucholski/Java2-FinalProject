package finalproj;

public class Room {

	Player1 player = new Player1();
	PlayerActions actions = new PlayerActions();
	
	public void enterRoom() {
		System.out.println("You have entered the room. Before you there is some stuff.....");
		System.out.println("What do you do next?");
		actions.reviewActions();
	}
}
