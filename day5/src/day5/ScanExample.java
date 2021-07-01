package day5;
import java.util.Scanner;

public class ScanExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Type in a line and hit Enter.");
		
		String line = scanner.nextLine();
		System.out.println("You typed: " + line);
		
		scanner.close();
		
		String numbers = " 1 2 3 5 7 9";
		
		scanner = new Scanner(numbers);
		
		while (scanner.hasNextInt()) {
			System.out.print(scanner.nextInt() + " ");
		}
		
		scanner.close();
	}

}
