package finalproj;
import java.util.List;
import java.util.ArrayList;

public class Room  {

	private String name;
	private String description;

	private int kitchen, dining, pantry, freezer;
	private List<String> items;


	public Room(String name, String desc, int kitchen, int dining, int pantry, int freezer ){
		this.name = name;
		this.description = desc;
		this.kitchen = kitchen;
		this.dining = dining;
		this.pantry = pantry;
		this.freezer = freezer;
		this.items = new ArrayList<>();
		this.description = description;
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

	public int getKitchen(){
		return kitchen;
	}
	public void setKitchen(int kitchen){
		this.kitchen = kitchen;
	}
	public int getPantry(){
		return pantry;
	}
	public void setPantry(int pantry){
		this.pantry = pantry;
	}
	public int getFreezer(){
		return freezer;
	}
	public void setFreezer(int freezer){
		this.freezer = freezer;
	}
	public int getDining(){
		return dining;
	}
	public void setDining(int dining){
		this.dining = dining;
	}

	// Methods for item management
	public void addItem(String item) {
		this.items.add(item);
	}

	public boolean removeItem(String item) {
		return items.remove(item);
	}

	public List<String> getItems() {
		return new ArrayList<>(items);
	}

	// Override toString() method
	@Override
	public String toString() {
		return "Room: " + name + "\nDescription: " + description + "\nItems: " + items.toString();
	}

	/**PlayerActions actions = new PlayerActions();
	
	public void enterRoom() {
		System.out.println("You have entered the room. Before you there is some stuff.....");
		System.out.println("What do you do next?");
		actions.reviewActions();
	}**/
}
