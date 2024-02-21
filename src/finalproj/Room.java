package finalproj;

public class Room {

	String name;
	String description;

	private int kitechen, dining, pantry, freezer;

	public Room(String name, String desc){
		this.name = name;
		this.description = desc;
	}

	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getDescription(){
		return description;
	}
	public void setDescription(String description){
		this.description = description;
	}

	/**PlayerActions actions = new PlayerActions();
	
	public void enterRoom() {
		System.out.println("You have entered the room. Before you there is some stuff.....");
		System.out.println("What do you do next?");
		actions.reviewActions();
	}**/
}
