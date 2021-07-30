package groupSorterAspp;

import java.util.ArrayList;
import java.util.Collections;
//import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/*
 * Create a group sorter app, console based app, that will list down the
 * groups in ascending or descending order based on the average score of members of the group
 * 
 * Features include
 * 
 * 1. Add groups
 * 2. Add members to groups
 *    A*A1|A2|A3#B*B1|b2|b3
 * 
 * 3. Add scores of each member for a given event
 * 	  Event1>A1*90|A2*56|...
 * 	  Event2>A1*78|A2*45|...
 * 	  Event3>A1*45|A2*66|...
 * 
 * 4. Show the groups with scores descending
 * A - 89
 * B - 86
 * C - 78
 */

public class Main {
	 public static void main(String args[]){
		 
		 //getting students names
		 Scanner sc = new Scanner(System.in);
		 
		 System.out.println("Enter User 1:");
		 String student1 = sc.nextLine();
		 System.out.println("Enter User 2:");
		 String student2 = sc.nextLine();
		 System.out.println("Enter User 3:");
		 String student3 = sc.nextLine();
		 System.out.println("Enter User 4:");
		 String student4 = sc.nextLine();
		 System.out.println("Enter User 5:");
		 String student5 = sc.nextLine();
		 
		 
		 
		 //creating set for each user
		 HashSet<Integer> user1 = new HashSet<Integer>();
		 HashSet<Integer> user2 = new HashSet<Integer>();
		 HashSet<Integer> user3 = new HashSet<Integer>();
		 HashSet<Integer> user4 = new HashSet<Integer>();
		 HashSet<Integer> user5 = new HashSet<Integer>();
		 
		 
		 //getting input for users tests
		 System.out.println("Enter " + student1 + "'s test 1 score:");
		 Integer su11 = sc.nextInt();
		 System.out.println("Enter " + student1 + "'s test 2 score:");
		 Integer su12 = sc.nextInt();
		 System.out.println("Enter " + student1 + "'s test 3 score:");
		 Integer su13 = sc.nextInt();
		 user1.add(su11);
		 user1.add(su12);
		 user1.add(su13);

		 System.out.println("Enter " + student2 + "'s test 1 score:");
		 Integer su21 = sc.nextInt();
		 System.out.println("Enter " + student2 + "'s test 2 score:");
		 Integer su22 = sc.nextInt();
		 System.out.println("Enter " + student2 + "'s test 3 score:");
		 Integer su23 = sc.nextInt();
		 user2.add(su21);
		 user2.add(su22);
		 user2.add(su23);

		 System.out.println("Enter " + student3 + "'s test 1 score:");
		 Integer su31 = sc.nextInt();
		 System.out.println("Enter " + student3 + "'s test 2 score:");
		 Integer su32 = sc.nextInt();
		 System.out.println("Enter " + student3 + "'s test 3 score:");
		 Integer su33 = sc.nextInt();
		 user3.add(su31);
		 user3.add(su32);
		 user3.add(su33);

		 System.out.println("Enter " + student4 + "'s test 1 score:");
		 Integer su41 = sc.nextInt();
		 System.out.println("Enter " + student4 + "'s test 2 score:");
		 Integer su42 = sc.nextInt();
		 System.out.println("Enter " + student4 + "'s test 3 score:");
		 Integer su43 = sc.nextInt();
		 user4.add(su41);
		 user4.add(su42);
		 user4.add(su43);

		 System.out.println("Enter " + student5 + "'s test 1 score:");
		 Integer su51 = sc.nextInt();
		 System.out.println("Enter " + student5 + "'s test 2 score:");
		 Integer su52 = sc.nextInt();
		 System.out.println("Enter " + student5 + "'s test 3 score:");
		 Integer su53 = sc.nextInt();
		 user5.add(su51);
		 user5.add(su52);
		 user5.add(su53);
		 
		 
		 //sorting the users' scores
		 List<Integer> sortUser1 = new ArrayList<Integer>(user1);
		 Collections.sort(sortUser1);
		 List<Integer> sortUser2 = new ArrayList<Integer>(user2);
		 Collections.sort(sortUser1);
		 List<Integer> sortUser3 = new ArrayList<Integer>(user3);
		 Collections.sort(sortUser1);
		 List<Integer> sortUser4 = new ArrayList<Integer>(user4);
		 Collections.sort(sortUser1);
		 List<Integer> sortUser5 = new ArrayList<Integer>(user5);
		 Collections.sort(sortUser1);
		 
		 
		 //print out student scores
		 System.out.println(student1 + ": " + sortUser1);
		 System.out.println(student2 + ": " + sortUser2);
		 System.out.println(student3 + ": " + sortUser3);
		 System.out.println(student4 + ": " + sortUser4);
		 System.out.println(student5 + ": " + sortUser5);
		 
		 //end -- close scanner
		 sc.close();
		 
		 
//		 HashMap<String, Integer, Integer> hmap = new HashMap<>();
//	        Scanner sc = new Scanner(System.in);
//
//	        System.out.println("Enter first user:");
//	        String a = sc.nextLine();
//	        
//	        System.out.println("Enter test score 1:");
//	        Integer b = sc.nextInt();
//	        
//	        hmap.put(a, b);
//	        System.out.println(hmap);
	        
	        
//	        for (int i = 0; i < 3; i++) {
//	            Integer a = sc.nextInt();
//	            Integer b = sc.nextInt();
//	            
//	            hmap.put(a, b);
//
//	            System.out.println(hmap);
//	        }
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
//	       System.out.print("Enter 2D array size : ");
//	       Scanner sc=new Scanner(System.in);
//	       int rows=sc.nextInt();
//	       int columns=sc.nextInt();
//	       
//	       System.out.println("Enter array elements : ");    
//	        
//	       int twoD[][]=new int[rows][columns];
//	        
//	          
//	        for(int i=0; i<rows;i++)
//	         {            
//	            for(int j=0; j<columns;j++)
//	            {
//	                twoD[i][j]=sc.nextInt();
//	            }
//	         }
//	        System.out.print("\nData you entered : \n");
//	        for(int []x:twoD){
//	            for(int y:x){
//	            System.out.print(y+"        ");
//	            }
//	            System.out.println();
//	        }
//	        
//	        sc.close();
	    }  
}
