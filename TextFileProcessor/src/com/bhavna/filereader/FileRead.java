package com.bhavna.filereader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FileRead {

	Map<String, List<PersonData>> m = new HashMap<>();

	public void ProcessData() throws IOException {
		File file = new File("login.txt");

		BufferedReader br = new BufferedReader(new FileReader(file));

		String st;

		while ((st = br.readLine()) != null) {
			String[] st1 = st.split("\\n");
			for (String s : st1) {
				s = s.replaceAll("\\s{2,}", " ").trim();
				String[] st2 = s.split("\\s");

				if (m.containsKey(st2[1])) {
					List<PersonData> l1 = m.get(st2[1]);
					l1.add(new PersonData(st2[0], st2[1], st2[2] + " " + st2[3]));
					m.put(st2[1], l1);
				} else {
					List<PersonData> l2 = new ArrayList<>();
					l2.add(new PersonData(st2[0], st2[1], st2[2] + " " + st2[3]));
					m.put(st2[1], l2);

				}

			}
		}
	}

	public void PrintDataByDate(String date) {
		try {
			if (m.containsKey(date))
                 System.out.println("the details of persons logged on  "+ date +" are "+ m.get(date));
			else
				throw new DateNotFoundException("The Date you have entered is not present. enter valid date.");
		} catch (DateNotFoundException e) {
             System.out.println(e.getMessage());
		}
	}

	public void PrintCountByDate(String date) {
		try {
			if (m.containsKey(date))
                 System.out.println("the count of no of persons logged on "+ date +" are "+ m.get(date).size());
			else
				throw new DateNotFoundException("The Date you have entered is not present. enter valid date.");
		} catch (DateNotFoundException e) {
             System.out.println(e.getMessage());
		}
	}

	public void printAll() {
		for (Map.Entry<String, List<PersonData>> entry : m.entrySet()) {
			System.out.println("Date : " + entry.getKey());
			System.out.println("no of persons logged on this date : ");
			System.out.println(entry.getValue().size());
			System.out.println(entry.getValue());
		}
	}

}
