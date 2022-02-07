package com.bhavna.filereader;

public class PersonData {

	String name;
	String Date;
	String time;

	public PersonData() {
		super();
	}

	public PersonData(String name, String date, String time) {
		
		this.name = name;
		this.Date = date;
		this.time = time;
	}

	

	@Override
	public String toString() {
		return "PersonData [name=" + name + ", Date=" + Date + ", time=" + time + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
