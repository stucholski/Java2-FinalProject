package finalproj;

public class Help {
	PlayerActions actions = new PlayerActions();
	String enter = "You have entered the room.";
	public void helpText() {
		System.out.println("In this game, you can use the following verbs to move the player or use items....");
		System.out.println("What do you do next?");
		actions.reviewActions();
	}

}
