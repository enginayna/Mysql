package MysqlConnection;

import java.sql.DriverManager;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class SingleConnection {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection baglanti = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/veli", "root", "");
		Statement komut = (Statement) baglanti.createStatement();
		System.out.printf("Baðlantý Baþarýlý");
		baglanti.close();
	}
	}
