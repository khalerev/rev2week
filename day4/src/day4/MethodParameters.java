package day4;

public class MethodParameters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//class instance
		MethodParameters mp = new MethodParameters();
		
		//call method
		double d = mp.convertIntToDouble(44);
		
		System.out.println(d);
		
		System.out.println(mp.sum(3.0, 5, 2));
	}
	
	//create method
	public double convertIntToDouble(int num) {
		return (double)num;
	}
	
	public double sum(double num1, int num2, int num3) {
		return num1 + num2 + num3;
	}
}
