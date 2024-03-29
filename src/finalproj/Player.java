package finalproj;
import java.util.List;
import java.util.ArrayList;

public class Player  {
	private String name;
	private Room room;


	public String getName(){
		return this.name;
	}

	public void setName(String name){
		this.name = name;
	}
	public void setRoom(Room aRoom){
		this.room = aRoom;
	}
	public Room getRoom(){
		return this.room;
	}
	public Player(String aName, Room aRoom){
		this.name = aName;
		this.room = aRoom;
	}

	// Assuming other attributes are defined here
	private List<String> inventory = new ArrayList<>();

	public void addToInventory(String item) {
		inventory.add(item);
	}


	public boolean removeFromInventory(String item) {
		return inventory.remove(item);
	}

	public List<String> getInventory() {
		return new ArrayList<>(inventory);
	}


}
