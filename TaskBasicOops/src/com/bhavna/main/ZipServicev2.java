package com.bhavna.main;

import java.util.*;

import com.bhavna.address.Area;

public class ZipServicev2 implements ZipServicev1 {
	static Map<Integer, Area> m;

	static {
		m = new HashMap();
		m.put(509360, new Area("India", "Telangana", "Nagarkurnool", 509360));
		m.put(500001, new Area("India", "Telangana", "Hyderabad", 500001));
		m.put(502267, new Area("India", "Telangana", "Karimnagar", 502267));
		m.put(504001, new Area("India", "Telangana", "Adilabad", 504001));
		m.put(507001, new Area("India", "Telangana", "Khammam", 507001));
		m.put(506001, new Area("India", "Telangana", "Warangal", 506001));
		m.put(500074, new Area("India", "Telangana", "Rangareddy", 500074));
		m.put(503001, new Area("India", "Telangana", "Nizambad", 503001));
		m.put(502110, new Area("India", "Telangana", "Medak", 502110));
		m.put(508001, new Area("India", "Telangana", "Nalgonda", 508001));

	}

	public Area getDetailsByZip(int zipCode) {
		return m.get(zipCode);
	}

	public void printAll() {

		for (Map.Entry<Integer, Area> set : m.entrySet()) {

			System.out.println(set.getKey() + " : " + set.getValue());
		}

	}
	
	public void addZipCode(int zip1,Area area) {
		
		if(m.containsKey(zip1)) {
			System.out.println("zipcode already exists");
		}else {
		m.put(zip1, area);
		}
	}	
	

}
