
public class ClassB {
	ClassA classA = new ClassA();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassB b = new ClassB();
		b.classA.setName("Bob");
		
		System.out.println(b.classA.getName());
		
	}

}
