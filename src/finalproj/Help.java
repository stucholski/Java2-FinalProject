package finalproj;

public class Help {
	PlayerActions actions = new PlayerActions();
	String enter = "You have entered the room.";
	public void helpText() {
		System.out.println("ACTIONS:");
		System.out.println("\tgo to:");
		System.out.println("\topen");
		System.out.println("\take");
		System.out.println("\tread");
		System.out.println("\tturn on");
		System.out.println("\tturn off");

		System.out.println();

		System.out.println("ROOMS:");
		System.out.println("\troom1");
		System.out.println("\troom2");
		System.out.println("\troom3");
		System.out.println("\troom4");

		System.out.println("\tOBJECTS:");
		System.out.println("\tTo find objects, look around and pay attention....");




		System.out.println("go to:");
		System.out.println("What do you do next?");
		actions.reviewActions();
	}

}
