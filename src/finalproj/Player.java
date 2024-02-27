package finalproj;

public class Player {

	String name;

	Room currentRoom;

	PlayerActions actions; // to-do

	PlayerInventory inventory;

	Item itemInHand; // to-do


	/**
	 * Initializes the player and its configurations
	 * @param name the name of the player
	 * @param currentRoom The initial room for the player
	 */
	public Player(String name, Room currentRoom) {
		this.currentRoom = currentRoom;
		actions = new PlayerActions();
		inventory = new PlayerInventory(50, "Chef's Inventory");
		this.name = name;
	}

	/**
	 * Go to a directions: north, south, east, west
	 * @param direction direction to go to
	 */
	public void goTo(String direction){
		String message = currentRoom.goTo(direction);
		System.out.println(message);
	}

	/**
	 * Look to a direction do get a description of what you see
	 * @param direction direction you are looking towards
	 */
	public void lookTo(String direction){
		String message = currentRoom.lookTo(direction);
		System.out.println(message);
	}
}
