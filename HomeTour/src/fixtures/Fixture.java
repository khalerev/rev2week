package fixtures;

public abstract class Fixture {
	/*
	 * This abstract class will be used as a base for anything that can be looked at or interacted with.
	 * This class should define (at least) the following properties:
	 * 
	 * String name: a short name/title for the fixture
	 * String shortDescription: a one-sentence-long description of a fixture, used to briefly mention the fixture
	 * String longDescription: a paragraph-long description of the thing, displayed when the player
	 * 				investigated the fixture thoroughly (looks at it, or enters a room)
	 * 
	 */
	
	protected String name;
	protected String shortDescription;
	protected String longDescription;
	
	public Fixture (String name, String shortDescription, String longDescription) {
		this.name = name;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
	}
	
	
	//getter setters
	public  String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public  String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	
	public String getLongDescription() {
		return longDescription;
	}
	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}
	
	//override toString to produce useful information for user
	public String toString() {
		return "Name: " + name + ", short Description: " + shortDescription + ", long Description: " + longDescription;
	}
}
