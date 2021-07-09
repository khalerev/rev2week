package labRecursiveAlgorithm;

public class LinearSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//dummy data
		char letter = 'v';
		
		char[] letters = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
				'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r','s', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
		
		//call methods here
		LinearSearch ls = new LinearSearch();
		
		System.out.println(ls.findLetter(letter, letters));
	}
	
	//first method
	public int findLetter(char target, char[] data) {
		if (data == null) return -1;
		
		int result = -1;
		
		//loop through data
		for (int i = 0; i < data.length; i++) {
			char temp = data[i];
			
			//test current element against target
			if (temp == target) {
				return i;
			}
		}
		
		return result;
	}
}
