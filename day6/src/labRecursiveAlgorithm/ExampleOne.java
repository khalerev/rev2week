package labRecursiveAlgorithm;

public class ExampleOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create some dummy date for our method
		int input = 30;
		
		ExampleOne eo = new ExampleOne();
		
		//call methods here
		System.out.println(eo.factorial(input));
	}
	
		//first method
	public int factorial(int num) {
		if (num <= 0) return 0;
		if (num == 1) return 1;
		
		return num * factorial(num-1);
	}
}
