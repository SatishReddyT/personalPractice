package tasksAssigned.basic.oops;

import java.util.Scanner;

public class Main {

	public static int zip;
	
	public static void main(String[] args) {
		
		getZIP();
	}
	
	public  static int getZIP() {
		
	       System.out.println("Enter a ZIP code : ");
	        Scanner sc = new Scanner(System.in);
	        zip = sc.nextInt();
	        while((zip>599999)||(zip<500000))
	        {
	            System.out.println("**** ERROR ****");
	            System.out.println("The ZIP code must be between 500000 and 599999");
	            System.out.println("Please,enter the correct zip : ");
	            zip = sc.nextInt();
	        }
	        return zip;
	    }
		


}
