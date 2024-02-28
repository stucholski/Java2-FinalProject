package finalproj;
import java.util.List;
import java.util.ArrayList;
/**
 * The player class for the player's name and location.
 */
public class Player1 extends Thing {
    private String name;
    private Room room;

    @Override
    public String getName(){
        return this.name;
    }
    @Override
    public void setName(String name){
        this.name = name;
    }
    public void setRoom(Room aRoom){
        this.room = aRoom;
    }
    public Room getRoom(){
        return this.room;
    }
    public Player1(String aName, Room aRoom){
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
    /**public static void main (String [] args){
     Player1 player = new Player1("Hero",	);
     player.setName("Hero");
     player.setRoom("");

     System.out.println(player.name);
     }**/
}
