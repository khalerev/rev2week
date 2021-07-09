package game;

import fixtures.Room;

public class RoomManager {
	/*
	 * Responsible for "loading" our rooms into memory. When game.Main is executed, it will invoke
	 * the init() method in this class that will instantiate all our Room objects, link them together
	 * as exits, and designate a startingRoom
	 */
	
	/*
	 * startingRoom: the room a player should start in
	 * Room[] rooms: all the rooms in the house
	 */
	
	private Room startingRoom;
	
	public Room[] rooms;
	
	public RoomManager( ) {
		rooms = new Room[10];
	}
	
	public void init() {
		Room kitchen = new Room(
				"Kitchen",
				"a fancy kitchen room",
				"The heart of the house where all the food is made."
				+ "\nTo the west is the living room."
				+ "\nTo the north is the hallway."
				+ "\nTo the east is the dining room."
				+ "\nTo the south is the patio." + "\n");
		this.rooms[0] = kitchen;
		
		Room foyer = new Room(
				"The Foyer",
				"a small foyer",
				"The small entryway of a neo-colonial house. A large table can be seen."
				+ "\nTo the west is the dining room."
				+ "\n");
		this.rooms[1] = foyer;
				
		Room diningRoom = new Room(
				"Dining Room",
				"a fancy dining room",
				"The busiest place of the house where all the food is eaten."
				+ "\nTo the west is the kitchen."
				+ "\nTo the east is foyer."
				+ "\n");
		this.rooms[2] = diningRoom;

		Room hallway = new Room(
				"Hallway",
				"smallest of hallways",
				"Somehow only leads to one room"
				+ "\nTo the east is the guest room."
				+ "\nTo the south is the kitchen." + "\n");
		this.rooms[3] = hallway;
				
		Room guestRoom = new Room(
				"Guest Room",
				"only made for sleeping",
				"most disappointing guest room you ever saw"
				+ "\nTo the west is the living room."
				+ "\n");
		this.rooms[4] = guestRoom;
				
		Room patio = new Room(
				"Patio",
				"a wide patio",
				"a very beautiful patio but it isn't maintained"
				+ "\nTo the north is the kitchen."
				+ "\nTo the south is the backyard." + "\n");
		this.rooms[5] = patio;
				
		Room backyard = new Room(
				"Backyard",
				"a huge backyard",
				"The backyard looks unmaintained, trees are dying, flowers has wilted, weeds are sprouting"
				+ "\nTo the north is the patio."
				+ "\n");
		this.rooms[6] = backyard;
				
		Room livingRoom = new Room(
				"Living Room",
				"spacious room",
				"Lots of room and seats meant for huge gatherings"
				+ "\nTo the west is the porch."
				+ "\nTo the east is the kitchen."
				+ "\n");
		this.rooms[7] = livingRoom;
				
		Room porch = new Room(
				"Porch",
				"a neat porch",
				"Nicely designed porch but no one has cleaned it in awhile"
				+ "\nTo the west is the front yard."
				+ "\nTo the east is the living room."
				+ "\n");
		this.rooms[8] = porch;
				
		Room frontYard = new Room(
				"Front Yard",
				"a huge front yard",
				"All the leaves have fallen, flowers wilted, not much to see here at all."
				+ "\nTo the east is where you will find the door out to the patio."
				+ "\n");
		
		this.rooms[9] = frontYard;
		
		//setting exits (north, east, south, west)
		kitchen.setExits(hallway, diningRoom, patio, livingRoom);
		foyer.setExits(foyer, foyer, foyer, diningRoom);
		diningRoom.setExits(diningRoom, foyer, diningRoom, kitchen);
		hallway.setExits(hallway, guestRoom, kitchen, hallway);
		guestRoom.setExits(guestRoom, guestRoom, guestRoom, hallway);
		patio.setExits(kitchen, patio, backyard, patio);
		backyard.setExits(patio, backyard, backyard, backyard);
		livingRoom.setExits(livingRoom, kitchen, livingRoom, porch);
		porch.setExits(porch, livingRoom, porch, frontYard);
		frontYard.setExits(frontYard, porch, frontYard, frontYard);
		
		//setting interactives
		String[] interactives = {"knife"};
		kitchen.setInteractive(interactives);
		interactives = new String[] {"plates", "forks"};
		diningRoom.setInteractive(interactives);
		this.startingRoom = kitchen;
	}
	
	public Room getStartingRoom() {
		return this.startingRoom;
	}
	
	public void setStartingRoom(Room startingRoom) {
		this.startingRoom = startingRoom;
	}
}
