package com.bhavna;

import java.sql.*;
import java.util.Scanner;

public class Operations {

	Scanner sc = new Scanner(System.in);
	static String url = "jdbc:sqlserver://localhost\\BHAVNAWKS734:1433;databaseName=firstSql;encrypt=true;trustServerCertificate=true";
	static String username = "sa";
	static String password = "Bhavna@123";
	static Connection connect;
	Statement stmt = null;
	ResultSet rs = null;

	int condition = 0;

	public void userChoice() {
		while (true) {
			System.out.println("enter 1 to add details in employeeDetails table");
			System.out.println("enter 2 to add details in department table");
			System.out.println("enter 3 to get details in employeeDetails and department tables");
			System.out.println("enter 4 to get count of employees whose sal is greater than 30000");
			System.out.println("enter 5 to update details in employeeDetails table");
			int number = sc.nextInt();

			switch (number) {
			case 1:
				addEmployeeData();
				break;

			case 2:
				addDeptData();
				break;

			case 3:
				fetchingData();
				break;

			case 4:
				getSalCount();
				break;

			case 5:
				updateEmployeeDetails();
				break;

			default:
				System.out.println("enter valid number");

			}
			System.out.println("do you want to continue ? enter 0");
			condition = sc.nextInt();
			if (condition != 0) {
				break;
			}
		}
	}

	public void addEmployeeData() {
		try {

			Connection connect = DriverManager.getConnection(url, username, password);

			String sql = "INSERT INTO employeeDetails VALUES" + "(?,?,?,?,?)";

			PreparedStatement prep = connect.prepareStatement(sql);

			System.out.println("enter employee id : ");
			int id = sc.nextInt();
			prep.setInt(1, id);
			System.out.println("enter employee name : ");
			String name = sc.next();
			prep.setString(2, name);
			System.out.println("enter employee sal : ");
			int sal = sc.nextInt();
			prep.setInt(3, sal);
			System.out.println("enter employee hireDate : ");
			String date = sc.next();
			prep.setDate(4, java.sql.Date.valueOf(date));
			System.out.println("enter employee deptId : ");
			String deptId = sc.next();
			prep.setString(5, deptId);

			int i = prep.executeUpdate();
			if (i != 0) {
				System.out.println("Row is created");
			} else {
				System.out.println("Row is not created");
			}
			connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void addDeptData() {
		try {

			Connection connect = DriverManager.getConnection(url, username, password);
			String sql = "INSERT INTO department VALUES" + "(?,?,?)";

			PreparedStatement prep = connect.prepareStatement(sql);

			System.out.println("enter employee deptId : ");
			int id = sc.nextInt();
			prep.setInt(1, id);
			System.out.println("enter employee deptName : ");
			String deptName = sc.next();
			prep.setString(2, deptName);
			System.out.println("enter employee loc : ");
			String loc = sc.next();
			prep.setString(3, loc);

			int i = prep.executeUpdate();
			if (i != 0) {
				System.out.println("Row is created");
			} else {
				System.out.println("Row is not created");
			}
			connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void fetchingData() {

		try {
			Connection connect = DriverManager.getConnection(url, username, password);
			stmt = connect.createStatement();

			// Constructing The SQL Query

			String sql = "SELECT * FROM employeeDetails inner join department on employeeDetails.deptId=department.deptId";

			rs = stmt.executeQuery(sql);

			// Processing the ResultSet object

			while (rs.next()) {
				System.out.println("empId :" + rs.getInt("empId"));

				System.out.println("empName : " + rs.getString("empName"));

				System.out.println("sal :" + rs.getInt("sal"));

				System.out.println("hireDate :" + rs.getDate("hireDate"));

				System.out.println("deptId : " + rs.getString("deptId"));

				System.out.println("deptName : " + rs.getString("deptName"));

				System.out.println("loc : " + rs.getString("loc"));

			}

			connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void getSalCount() {

		try {
			Connection connect = DriverManager.getConnection(url, username, password);
			stmt = connect.createStatement();

			// Constructing The SQL Query

			String sql = "SELECT deptName,count(*) as total FROM employeeDetails inner join department on employeeDetails.deptId=department.deptId where employeeDetails.sal>30000 group by department.deptName";

			rs = stmt.executeQuery(sql);

			// Processing the ResultSet object
			while (rs.next()) {
				System.out.println("deptName :" + rs.getString("deptName"));

				System.out.println("total : " + rs.getInt("total"));

			}

			connect.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateEmployeeDetails() {

		try {
			Connection connect = DriverManager.getConnection(url, username, password);
			String sql = "UPDATE employeeDetails SET empName=?,sal=?,hireDate=?,deptId=?" + " WHERE empId=?";

			PreparedStatement prep = connect.prepareStatement(sql);

			System.out.println("enter employee name");
			String name = sc.next();
			prep.setString(1, name);
			System.out.println("enter employee sal : ");
			int sal = sc.nextInt();
			prep.setInt(2, sal);
			System.out.println("enter employee hireDate : ");
			String date = sc.next();
			prep.setDate(3, java.sql.Date.valueOf(date));
			System.out.println("enter employee deptId : ");
			String deptId = sc.next();
			prep.setString(4, deptId);
			System.out.println("enter id");
			int id = sc.nextInt();
			prep.setInt(5, id);

			int i = prep.executeUpdate();

			if (i != 0) {
				System.out.println("Record is updated");
			} else {
				System.out.println("Record is not updated");
			}
			connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
