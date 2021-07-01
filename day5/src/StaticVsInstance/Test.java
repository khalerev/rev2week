package StaticVsInstance;

public class Test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A.staticCount = 2494;
		System.out.println("clas A staticCount: " + A.staticCount);
		
		A a = new A();
		System.out.println(a.instanceCount);
		System.out.println(A.staticCount);
		System.out.println(a.instanceCount);
		System.out.println(a.instanceCount);
		System.out.println(a.instanceCount);
		
		A a2 = new A();
		System.out.println(A.staticCount);
		
		A a3 = new A();
		System.out.println(A.staticCount);
		A a4 = new A();
		System.out.println(A.staticCount);
		A a5 = new A();
		System.out.println(A.staticCount);
		System.out.println(a2.instanceCount);
		System.out.println(A.staticCount);
		
		a.instanceCount = 15;
		
		System.out.println("object a instanceCount: " + a.instanceCount);
		System.out.println("object a2 instanceCount: " + a2.instanceCount);
		System.out.println("class A staticCount: " + A.staticCount);
	}
}
