package game;

import fixtures.Room;

public class Runner {
	private static RoomManager manager = new RoomManager();
	//creating player
	public static Player player = new Player();
	
	
	public static void main(String[] args) {
		//initializes rooms, exits.... starts program
		manager.init();
		
		
		//printing instructions on how to play the game
		Menus.printInstructions();
		
		//start player in starting room
		player.setCurrentRoom(manager.getStartingRoom());
		Menus.printRoom(player);
		
		while(Input.command != "quit") {
			Input.printInput();
//			Menus.printRoom(player);
//			System.out.println(player.getCurrentRoom().getExits(Input.command));
			player.setCurrentRoom(player.getCurrentRoom().getExits(Input.command));
			Menus.printRoom(player);
//			System.out.println("Current Room: " + player.getCurrentRoom());
			
			if(Input.command.equals("quit")) {
				System.out.println("Thanks for playing");
				System.exit(0);
			}
		}
		
		System.out.println(manager.rooms[0]);
		
		//closes the scanner
		Input.n.close();
	}
}
