package day5;

public class Constructors {
	
	public Constructors () {
		System.out.println("Default constructor ran.");
	}
	
	public Constructors (int value) {
		System.out.println(value);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Constructors c = new Constructors(5839);
		
		Constructors cNoArg = new Constructors();
	}

}
