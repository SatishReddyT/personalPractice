package com.bhavna.address;



public class Area extends State {

	
	protected String area;
	protected int zip;

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Area(String country,String state,String area,int zip) {
		super.country=country;
		super.state=state;
		this.area=area;
		this.zip=zip;
	}

	@Override
	public String toString() {
		return "Area [area : " + area  + ", state : " + state + ", country : " + country + ", zip : " + zip+ "]";
	}
	
	
}	