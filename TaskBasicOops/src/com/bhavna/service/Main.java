package com.bhavna.service;

import java.util.Scanner;

import com.bhavna.address.Area;
import com.bhavna.main.ZipServicev1;
import com.bhavna.main.ZipServicev2;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		ZipServicev1 zipService2 = new ZipServicev2();
		int condition=0;

		while(true) {

			System.out.println("enter the 1 to get the area by entering zip code : ");
			System.out.println("enter the 2 to get the zipcodes along withe area : ");
			System.out.println("enter the 3 to add new zipcode with address : ");
			int number = scan.nextInt();

			switch (number) {

			case 1:
				System.out.println("enter the  zipcode : ");
				int zipCode = scan.nextInt();
				Area value = zipService2.getDetailsByZip(zipCode);
				System.out.println(value);
				break;
			case 2:
				zipService2.printAll();
				break;
			case 3:
				System.out.println("enter the country name : ");
				String countryName = scan.next();
				System.out.println("enter the state name : ");
				String stateName = scan.next();
				System.out.println("enter the area name : ");
				String areaName = scan.next();
				System.out.println("enter the zip1 code : ");
				int zip1 = scan.nextInt();

				Area area = new Area(countryName, stateName, areaName, zip1);
				zipService2.addZipCode(zip1, area);
				break;
			default:
				System.out.println("enter the valid number");

			}
			
			System.out.println("do you want to continue ? enter 4");
			condition=scan.nextInt();
			if(condition!=4) {
				break;
			}
			
		}//while(condition==4);

	}

}
