package finalproj;

public class PickUp {
	PlayerActions actions = new PlayerActions();
	
	public void pickUpText() {
		System.out.println("Your have picked up the noodles.");
		System.out.println("What do you do next?");
		actions.reviewActions();
	}

}
