package labRecursion;

public class TestFib {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fib fib = new Fib();
		
		int result = fib.fibonacci(2);
		System.out.println(result);
		
		result = fib.fibonacci(5);
		System.out.println(result);
		
		result = fib.fibonacci(10);
		System.out.println(result);
		
		result = fib.fibonacci(50);
		System.out.println(result);
	}

}
