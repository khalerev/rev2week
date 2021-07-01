package day4;

public class ReturnType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReturnType rt = new ReturnType();
		
		rt.returnNothing();
		
		boolean b = rt.returnBoolean();
		
		System.out.println("The value of b is: " + b);
	}
	
	//methods
	public void returnNothing() {
		System.out.println("inside of a void method");
	}
	
	public boolean returnBoolean() {
		return false;
	}
}
