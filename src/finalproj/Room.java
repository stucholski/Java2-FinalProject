package finalproj;

public class Room {
	private String name;
	private String north;
	private String south;
	private String east;
	private String west;



	Room(String name, String north, String south, String east, String west){
		this.name = name;
		this.north = north;
		this.south = south;
		this.east = east;
		this.west = west;
	}

	/**
	 * Move to another location
	 * @param direction direction the user wants to go: north, south, east, west
	 * @return a string with the location you moved to.
	 */
	public String goTo(String direction) {

		String message;

		switch (direction){
			case "north":
				// Need to change player current room
				message = "You went to " + north;
				break;
			case "south":
				// Need to change player current room
				message = "You went to " + south;
				break;
			case "east":
				// Need to change player current room
				message = "You went to " + east;
				break;
			case "west":
				// Need to change player current room
				message = "You went to " + west;
				break;
			default:
				// send user message no good room;
				message = "Not a good location";
		}

		return message;
	}

	/**
	 * Return a description of the items you see in the direction you are looking towards.
	 * @param direction Direction you are looking towards
	 * @return a description of what you are seeing.
	 */
	public String lookTo(String direction) {

		String message;

		switch (direction){
			case "north":
				// Need to change player current room
				message = "You see " + north;
				break;
			case "south":
				// Need to change player current room
				message = "You see " + south;
				break;
			case "east":
				// Need to change player current room
				message = "You see " + east;
				break;
			case "west":
				// Need to change player current room
				message = "You see " + west;
				break;
			default:
				// send user message no good room;
				message = "What are you really looking at";
		}

		return message;
	}
}
