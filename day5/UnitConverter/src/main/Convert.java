package main;
import java.util.Scanner;

public class Convert {

	//variable to determine which formula to use
	static double n = 0; //final result
	static int convertingOption; //chosen converter
	static int convertingQuantity; //quantity to be converted
	static Scanner scanOption = new Scanner(System.in); //scanning first input
	static Scanner scanQuantity = new Scanner(System.in); //scanning second input
	
	static int cupsToTeaspoons(int i) {
		//multiply cups by 48 to convert to teaspoons
		return i * 48;
	}
	
	static double milesToKilometers(int i) {
		//multiply miles by 1.609 to convert to kilometers
		return (double)i * 1.609;
	}
	
	static double usGallonsToImperialGallons(int i) {
		//multiply cups by 48 to convert to teaspoons
		return (double)i / 1.201;
	}
	
	public static void option() {
		//collecting input for conversion option
				System.out.println("Please select an option: \n"
						+ "1. Cups to Teaspoons \n"
						+ "2. Miles to Kilometers \n"
						+ "3. US Gallons to Imperial Gallons \n"
						+ "4. Quit");
				
				convertingOption = scanOption.nextInt();
				
				
				System.out.println(convertingOption);
				
				switch(convertingOption) {
				case 1:
					//cups to teaspoons
					System.out.println("Cups to Teaspoons\n"
							+ "How many Cups?");
					break;
				case 2:
					//Miles to Kilometers
					System.out.println("Miles to Kilometers\n"
							+ "How many Miles?");
					break;
				case 3:
					System.out.println("US Gallons to Imperial Gallons\n"
							+ "How many US Gallons?");
					break;
				default:
					System.out.println("Exiting program");
					System.exit(0);
				}
				
	}
	
	public static int quantity() {
		System.out.println("Enter quantity: ");
		
		convertingQuantity = scanQuantity.nextInt();
		
		return convertingQuantity;
	}
	
	public static double convert() {
		switch(convertingOption) {
		case 1:
			n = cupsToTeaspoons(convertingQuantity);
			break;
		case 2:
			n = milesToKilometers(convertingQuantity);
			break;
		case 3:
			n = usGallonsToImperialGallons(convertingQuantity);
			break;
		default:
			System.out.println("Not working");
		}
		return n;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		option();
		quantity();
		convert();
		System.out.println(n);
		
		//closing out of scanners
		scanOption.close();
		scanQuantity.close();
	}
	
}


