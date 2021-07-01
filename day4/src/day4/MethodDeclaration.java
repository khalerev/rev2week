package day4;

public class MethodDeclaration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//class instance
		MethodDeclaration md = new MethodDeclaration();
		
		//call first method
		md.talk();
		md.talk();
		md.talk();
		md.talk();
	}
	
	//first method
	public void talk() {
		System.out.println("Inside of the talk method");
	}
}
