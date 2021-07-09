package game;

public class Menus {
	public static void printRoom(Player player) {
		System.out.println("CURRENT ROOM");
		System.out.println("Name: " + player.getCurrentRoom().getName());
		System.out.println("Short Description: " + player.getCurrentRoom().getShortDescription());
		System.out.println("Long Description: " + player.getCurrentRoom().getLongDescription());
	}
	
	//instructions for the game
	public static void printInstructions() {
		System.out.println("Scuffed Zork Game"
				+ "\nMove rooms by entering 'north/south/east/west'"
				+ "\nInteract with items by entering 'item name'");
	}
}
