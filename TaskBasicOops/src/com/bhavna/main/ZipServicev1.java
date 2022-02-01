package com.bhavna.main;

import com.bhavna.address.Area;

public interface ZipServicev1 {

	public Area getDetailsByZip(int zipCode);
	
	public  void printAll(); 
	
	public void addZipCode(int zip1,Area area);
}
