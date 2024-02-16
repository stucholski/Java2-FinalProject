package finalproj;

/**
 * The player class for the player's name and location.
 */
public class Player1 {
	private String name;
	private Room room;

	public String getName(String name){
		return name;
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
	public Player1(String aName, Room aRoom){
		this.name = aName;
		this.room = aRoom;
	}
	/**public static void main (String [] args){
		Player1 player = new Player1("Hero",	);
		player.setName("Hero");
		player.setRoom("");

		System.out.println(player.name);
	}**/
}