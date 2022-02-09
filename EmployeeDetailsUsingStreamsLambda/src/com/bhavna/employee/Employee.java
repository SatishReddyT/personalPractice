package com.bhavna.employee;

public class Employee {
	private String eName;
	private long sal;
	private String loc;

	@Override
	public String toString() {
		return "Employee [eName=" + eName + ", sal=" + sal + ", loc=" + loc + "]";
	}

	public Employee(String eName, int sal, String loc) {
		super();
		this.eName = eName;
		this.sal = sal;
		this.loc = loc;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public long getSal() {
		return sal;
	}

	public void setSal(long sal) {
		this.sal = sal;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

}
