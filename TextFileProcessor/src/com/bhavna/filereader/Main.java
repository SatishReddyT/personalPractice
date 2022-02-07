package com.bhavna.filereader;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {

		Scanner scan = new Scanner(System.in);
		FileRead file = new FileRead();
		file.ProcessData();
		int condition = 0;
		while (true) {
			System.out.println("enter 1 to get details of logged persons on specified date");
			System.out.println("enter 2 to get total no of persons logged on specified date");
			System.out.println("enter 3 to get details on all dates ");
			int number = scan.nextInt();
			String date;

			switch (number) {
			case 1:
				System.out.println("enter the date in dd/mm format : ");
				date = scan.next();
				file.PrintCountByDate(date);
				break;

			case 2:
				System.out.println("enter the date in dd/mm format : ");
				date = scan.next();
				file.PrintDataByDate(date);
				break;

			case 3:
				file.printAll();
				break;

			default:
				System.out.println("enter valid number");

			}
			System.out.println("do you want to continue ? enter 5");
			condition = scan.nextInt();
			if (condition != 5) {
				break;
			}

		}

	}

}
