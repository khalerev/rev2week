package fixtures;

public class Room extends Fixture{
	/*
	 * This class represents a room in the house. It will extend fixtures.Fixture, and so will inherit
	 * the descriptive properties. The Room will also have the following properties:
	 * 
	 * Room[] exits: the rooms adjacent to this one. You might decide that a room in a particular
	 * direction always uses certain index, e.g. a north exit always goes in index 0, an east exit always goes in index 1, etc.
	 * If so, then the size of this array depends on how many directions you want to support.
	 * 
	 * The room class should also have a constructor that accepts a name, shortDescription, and longDescription.
	 * You might also find it convenient to create a getter not just for all the exits,
	 * but for a particular exit given a direction
	 */
	
	//room with exit
	private Room[] exits = new Room[5];
	private String[] interactives;
	
	public Room(String name, String shortDescription, String longDescription) {
		super(name, shortDescription, longDescription);
	}
	
	public void setExits(Room north, Room east, Room south, Room west) {
		this.exits[0] = north;
		this.exits[1] = east;
		this.exits[2] = south;
		this.exits[3] = west;
		this.exits[4] = this;
	}
	
	public void setInteractive( String[] interactives) {
		this.interactives = interactives;
	}
	
	public Room getExits(String command) {
		switch(command) {
		case "north":
//			game.Runner.player.setCurrentRoom(rooms.exits[command]);
//			rooms[Runner.player.setCurrentRoom()].exits[0];
			return exits[0];
//			break;
		case "east":
			return exits[1];
//			break;
		case "south":
			return exits[2];
//			break;
		case "west":
			return exits[3];
//			break;
		default:
			return exits[4];
		}
	}
}
