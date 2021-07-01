package day4;

public class Overloading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//instances
		Overloading om = new Overloading();
		om.print();
		om.print("second method");
		om.print("five", "eight");
	}
	
	//overloaded methods
	public void print() {
		System.out.println("original print method.");
	}
	
	public void print(String str) {
		System.out.println(str);
	}
	
	public void print(String str, String str2) {
		System.out.println(str + " " + str2);
	}
}
