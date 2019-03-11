package Mysql;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class MysqlExample {

	private String userName;

	private String host;

	private String password;

	private Connection connection;

	private Statement statement;
	
	private ResultSet rs;

	public MysqlExample(String userName, String host, String password) {

		this.userName = userName;
		this.host = host;
		this.password = password;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {

			e1.printStackTrace();
		}
		try {
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/demodb", userName, password);
		} catch (SQLException e) {
			System.out.println("Driver bulunamadý.");
			// e.printStackTrace();
		}
		try {
			statement = (Statement) connection.createStatement();
			System.out.println("Baðlantý baþarýlý");
		} catch (SQLException e) {
			System.out.println("Baðlantý baþarýsýz");
			// e.printStackTrace();
		}
	}
	
	public void showTable() {
		try {
			rs = statement.executeQuery("Select*From personnel");
			
			while(rs.next()) {
				
				int ID = rs.getInt("ID");
				String name = rs.getString("Name");
				String surname = rs.getString("Surname");
				long identityNumber = rs.getLong("IdentityNumber");
				String email = rs.getString("Email");
				System.out.println("ID : " + ID + " Name : " + name + " Surname : " + surname
						+ " Identity Number : " + identityNumber + " Email : " + email);
			}
			
		} catch (SQLException e) {
			System.out.println("Table cannot be displayed");
			e.printStackTrace();
		}
	}
	
	public void addPersonnel(String name , String surname , long identityNumber , String email) {
		try {
			String query = "Insert Into personnel(Name , Surname , IdentityNumber , Email) VALUES("
				+ "'" + name + "'," + "'" + surname + "'," + "'" + identityNumber + "'," + "'" + email + "')";
			statement.executeUpdate(query);
;		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	public void updateName(String name , int ID){
		try {
			statement.executeUpdate("Update personnel Set Name =" + "'" + name + "'" + "Where ID = " + ID );
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void updateSurname(String surname , int ID) {
		try {
			statement.executeUpdate("Update personnel Set Surname =" + "'" + surname + "'" + "Where ID = " + ID );
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void updateIdentityNumber(long identityNumber , int ID ) {
		try {
			statement.executeUpdate("Update personnel Set IdentityNumber =" + "'" + identityNumber + "'" + "Where ID = " + ID );
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void updateEmail(String email , int ID) {
		try {
			statement.executeUpdate("Update personnel Set Email =" + "'" + email + "'" + "Where ID = " + ID );
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void deletePersonnel(int ID) {
		try {
			statement.executeUpdate("Delete From personnel Where ID = " + ID);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
	
	public void showLine(int ID) {
		try {
			rs = statement.executeQuery("Select * From personnel Where ID = " + ID );
			while(rs.next()) {
				String name = rs.getString("Name");
				String surname = rs.getString("Surname");
				long identityNumber = rs.getLong("IdentityNumber");
				String email = rs.getString("Email");
				System.out.println("ID : " + ID + " Name : " + name + " Surname : " + surname
						+ " Identity Number : " + identityNumber + " Email : " + email);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
