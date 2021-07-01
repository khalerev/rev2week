package day4;

public class MultiArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][][] my3dArray = new int[3][3][3];  
		  
		my3dArray[0][0][0] = 1;  
		System.out.println(my3dArray[0][0][0]);
		
		int[][] my2dArray =  {{1,2,0}, {4, 5, 6}, {1, 4, 5}};
		System.out.println(my2dArray[0][0]);
		System.out.println(my2dArray[0][1]);
		System.out.println(my2dArray[0][2]);
		System.out.println(my2dArray[1][0]);
		System.out.println(my2dArray[1][1]);
		System.out.println(my2dArray[1][2]);
		System.out.println(my2dArray[2][0]);
		System.out.println(my2dArray[2][1]);
		System.out.println(my2dArray[2][2]);
	}

}
